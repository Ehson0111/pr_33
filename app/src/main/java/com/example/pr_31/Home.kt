package com.example.pr_31

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pr_31.ui1.ProductCard
import com.example.pr_31.ui1.Slider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    navController: NavController,
    categories: List<Category>,
    products: List<Product>,
    onAddToCart: (Product) -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    if (categories.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
            Text("Загрузка категорий...", modifier = Modifier.padding(top = 16.dp))
        }
        return
    }

    var selectedCategory by remember { mutableStateOf(categories.first()) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 88.dp, top = 40.dp)
                .padding(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = {}, modifier = Modifier.size(44.dp)) {
                    Image(
                        painter = painterResource(R.drawable.menu),
                        contentDescription = "Menu",
                        contentScale = ContentScale.FillBounds
                    )
                }

                Image(
                    modifier = Modifier.size(126.dp, 33.dp),
                    painter = painterResource(R.drawable.base),
                    contentDescription = "Logo",
                    contentScale = ContentScale.FillBounds
                )

                IconButton(onClick = { navController.navigate("search") }, modifier = Modifier.size(44.dp)) {
                    Image(
                        painter = painterResource(R.drawable.iconwhite), // Замените на свою иконку поиска
                        contentDescription = "Search",
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Поиск", color = Color.Gray) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = {})
                )

                IconButton(onClick = { navController.navigate("search") }, modifier = Modifier.size(25.dp)) {
                    Image(
                        painter = painterResource(R.drawable.mn), // Замените на свою иконку
                        contentDescription = "Search",
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            Text(
                "Категории",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 22.dp, bottom = 22.dp)
            )

            Slider(
                items = categories,
                selectedCategory = selectedCategory,
                onItemSelected = { category ->
                    selectedCategory = category
                    if (category.id == 1) {
                        navController.navigate("allProducts")
                    }
                }
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Популярное",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 22.dp, bottom = 22.dp)
                )

                TextButton(onClick = { navController.navigate("allProducts") }) {
                    Text("Все", fontSize = 12.sp, color = colorResource(R.color.purple_700))
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                products.filterNotNull().take(2).forEach { product ->
                    ProductCard(product = product, onAddToCart = onAddToCart)
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Специальные предложения",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 22.dp, bottom = 22.dp)
                )

                TextButton(onClick = { navController.navigate("allProducts") }) {
                    Text("Все", fontSize = 12.sp, color = colorResource(R.color.purple_700))
                }
            }

            IconButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier.size(331.dp, 100.dp),
                    painter = painterResource(R.drawable.aks),
                    contentDescription = "Special Offers"
                )
            }
        }

        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(88.dp)
                .align(Alignment.BottomCenter),
            containerColor = Color.White
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = { /* Домашняя страница */ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_home),
                            contentDescription = "Главная",
                            tint = colorResource(R.color.purple_700)
                        )
                    }
                    Text("Главная", fontSize = 12.sp)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = { navController.navigate("search") }) {
                        Icon(
                            painter = painterResource(R.drawable.is_search),
                            contentDescription = "Поиск",
                            tint = Color.Gray
                        )
                    }
                    Text("Поиск", fontSize = 12.sp, color = Color.Gray)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = { navController.navigate("cart") }) {
                        Icon(
                            painter = painterResource(R.drawable.cart),
                            contentDescription = "Корзина",
                            tint = Color.Gray
                        )
                    }
                    Text("Корзина", fontSize = 12.sp, color = Color.Gray)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = { /* Избранное */ }) {
                        Icon(
                            painter = painterResource(R.drawable.icon),
                            contentDescription = "Избранное",
                            tint = Color.Gray
                        )
                    }
                    Text("Избранное", fontSize = 12.sp, color = Color.Gray)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = { /* Профиль */ }) {
                        Icon(
                            painter = painterResource(R.drawable.profile),
                            contentDescription = "Профиль",
                            tint = Color.Gray
                        )
                    }
                    Text("Профиль", fontSize = 12.sp, color = Color.Gray)
                }
            }
        }
    }
}