package com.example.pr_31.ui1


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.pr_31.Product
import com.example.pr_31.R
import com.example.pr_31.viewmodel.CartViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CatalogueItem(
    navController: NavController,
    product: Product,
    cartViewModel: CartViewModel
) {
    val itemCount = cartViewModel.getItemCount(product)
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    AppTheme {
        Card(
            modifier = if (screenWidth > 400.dp) Modifier
                .fillMaxWidth()
                .height(320.dp) // Увеличена общая высота карточки
                .padding(8.dp)
            else Modifier
                .fillMaxWidth()
                .height(280.dp) // Увеличена для мобильных устройств
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color(0xFFF5F5F5),
            onClick = {
                navController.navigate("item/${product.id}")
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Изображение товара
                AsyncImage(
                    model = product.image,
                    contentDescription = product.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp) // Оптимальная высота изображения
                        .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
                    contentScale = ContentScale.Crop
                )

                // Название товара
                Text(
                    text = "Best Seller",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    maxLines = 2,
                    lineHeight = 18.sp
                )

                // Вес/объем товара


                // Гибкий спейсер для заполнения пространства
                Spacer(modifier = Modifier.weight(1f))

                // Блок с кнопками/ценой
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    if (itemCount > 0) {
                        // Кнопка уменьшения количества
                        IconButton(
                            modifier = Modifier
                                .background(Color.White, RoundedCornerShape(8.dp))
                                .size(36.dp),
                            onClick = { cartViewModel.addToCart(product, -1) }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Уменьшить",
                                tint = colorResource(R.color.purple_700)
                            )
                        }

                        // Количество товара
                        Text(
                            text = itemCount.toString(),
                            fontSize = 16.sp,
                            modifier = Modifier.padding(horizontal = 8.dp),
                            fontWeight = FontWeight.Bold
                        )

                        // Кнопка увеличения количества
                        IconButton(
                            modifier = Modifier
                                .background(Color.White, RoundedCornerShape(8.dp))
                                .size(36.dp),
                            onClick = { cartViewModel.addToCart(product, +1) }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Увеличить",
                                tint = colorResource(R.color.purple_700)
                            )
                        }
                    } else {
                        // Кнопка "Добавить в корзину"
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            onClick = { cartViewModel.addToCart(product, +1) },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.White
                            ),
                            elevation = ButtonDefaults.elevation(
                                defaultElevation = 0.dp,
                                pressedElevation = 0.dp
                            )
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "${product.price_current } ₽",
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )


                            }
                        }
                    }
                }
            }
        }
    }
}


