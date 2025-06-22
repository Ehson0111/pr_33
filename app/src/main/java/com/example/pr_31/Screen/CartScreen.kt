package com.example.pr_31.Screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.pr_31.CartItem
import com.example.pr_31.Product
import com.example.pr_31.R
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CartScreen(navController: NavController, cartItems: List<CartItem>, onCartUpdate: (List<CartItem>) -> Unit) {
    // Инициализируем cart как изменяемую копию cartItems
    var cart by remember { mutableStateOf(cartItems.toMutableList()) }

    // Проверяем, что cart не пустой, для отладки
    if (cart.isEmpty()) {
        println("Cart is empty, check if items are added via onAddToCart")
    }

    val totalCost = cart.sumOf { (it.product.price_current ?: 0) * it.count }
    val deliveryCost = 60

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Корзина", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            tint = colorResource(R.color.purple_700),
                            contentDescription = "Back"
                        )
                    }
                },
                backgroundColor = Color.White
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            if (cart.isNotEmpty()) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 340.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(bottom = 120.dp)
                ) {
                    itemsIndexed(cart) { index, cartItem ->
                        val dismissState = rememberDismissState(
                            confirmStateChange = {
                                if (it == DismissValue.DismissedToEnd) {
                                    cart = cart.toMutableList().apply { removeAt(index) }
                                    onCartUpdate(cart)
                                    true
                                } else {
                                    false
                                }
                            }
                        )

                        SwipeToDismiss(
                            state = dismissState,
                            background = {
                                AnimatedVisibility(
                                    visible = dismissState.dismissDirection == DismissDirection.EndToStart
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(Color.Red.copy(alpha = 0.5f))
                                            .padding(horizontal = 16.dp),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        Text(
                                            text = "Удалить",
                                            color = Color.White,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                            },
                            directions = setOf(DismissDirection.EndToStart),
                            dismissContent = {
                                CartItemView(cartItem) { newCount ->
                                    cart = cart.toMutableList().apply { this[index].count = newCount }
                                    if (newCount <= 0) {
                                        cart.removeAt(index)
                                    }
                                    onCartUpdate(cart)
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(1.dp).background(Color(0x1F000000)))
                    }
                }

                // Нижняя часть с суммой, доставкой и кнопкой
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 16.dp)
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 20.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Сумма заказа", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Text("$totalCost ₽", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }

                    Divider(
                        color = Color.Gray.copy(alpha = 0.3f),
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Доставка", fontSize = 14.sp)
                        Text("$deliveryCost ₽", fontSize = 14.sp)
                    }

                    val totalWithDelivery = totalCost + deliveryCost
                    Button(
                        onClick = { /* Логика оформления заказа */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(top = 16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.purple_700)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Оформить заказ за $totalWithDelivery ₽",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.Center),
                        text = "Пусто, выберите блюда\nв каталоге :)",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun CartItemView(cartItem: CartItem, onCountChange: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = cartItem.product.image ?: "https://via.placeholder.com/50"),
            contentDescription = cartItem.product.name,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = cartItem.product.name ?: "Без названия",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "₽${(cartItem.product.price_current ?: 0) * cartItem.count}.00",
                fontSize = 16.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
            IconButton(
                onClick = { onCountChange(cartItem.count + 1) },
                modifier = Modifier.size(24.dp)
            ) {
                Text("+", fontSize = 18.sp, color = colorResource(R.color.purple_700))
            }
            Text(
                text = "${cartItem.count}",
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            IconButton(
                onClick = { onCountChange(cartItem.count - 1) },
                modifier = Modifier.size(24.dp)
            ) {
                Text("-", fontSize = 18.sp, color = colorResource(R.color.purple_700))
            }
        }
    }
}