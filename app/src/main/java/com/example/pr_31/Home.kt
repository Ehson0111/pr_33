////package com.example.pr_31
////
////import androidx.compose.foundation.Image
////import androidx.compose.foundation.layout.Arrangement
////import androidx.compose.foundation.layout.Box
////import androidx.compose.foundation.layout.Column
////import androidx.compose.foundation.layout.Row
////import androidx.compose.foundation.layout.fillMaxSize
////import androidx.compose.foundation.layout.fillMaxWidth
////import androidx.compose.foundation.layout.height
////import androidx.compose.foundation.layout.padding
////import androidx.compose.foundation.layout.size
////import androidx.compose.foundation.shape.RoundedCornerShape
////import androidx.compose.foundation.text.KeyboardActions
////import androidx.compose.foundation.text.KeyboardOptions
////import androidx.compose.material.BottomNavigation
////import androidx.compose.material.BottomNavigationItem
////import androidx.compose.material.Card
////import androidx.compose.material.IconButton
////import androidx.compose.material.MaterialTheme
////import androidx.compose.material.Text
////import androidx.compose.material.TextField
////import androidx.compose.material.TextFieldDefaults
////import androidx.compose.material3.BottomAppBar
////import androidx.compose.material3.CircularProgressIndicator
////import androidx.compose.material3.ExperimentalMaterial3Api
////import androidx.compose.material3.Icon
////import androidx.compose.material3.OutlinedTextField
////import androidx.compose.material3.TextButton
////import androidx.compose.runtime.Composable
////import androidx.compose.runtime.getValue
////import androidx.compose.runtime.mutableStateOf
////import androidx.compose.runtime.remember
////import androidx.compose.runtime.setValue
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.graphics.Color
////import androidx.compose.ui.graphics.vector.ImageVector
////import androidx.compose.ui.layout.ContentScale
////import androidx.compose.ui.platform.LocalConfiguration
////import androidx.compose.ui.res.colorResource
////import androidx.compose.ui.res.painterResource
////import androidx.compose.ui.res.vectorResource
////import androidx.compose.ui.text.input.ImeAction
////import androidx.compose.ui.unit.dp
////import androidx.compose.ui.unit.sp
////import androidx.navigation.NavController
////import com.example.pr_31.ui1.ProductCard
////import com.example.pr_31.ui1.Slider
////
//////import com.example.pr_31.ui1.Slider
////////
//////@OptIn(ExperimentalMaterial3Api::class)
//////@Composable
//////fun Home(navController: NavController) {
//////    val categories = remember {
//////        listOf(
//////            Category(1, "Все"),
//////            Category(2, "Outdoor"),
//////            Category(3, "Tennis"),
//////            Category(4, "Футбол"),
//////        )
//////    }
//////
//////    var selectedCategory by remember { mutableStateOf(categories.first()) }
//////    var searchText by remember { mutableStateOf("") }
//////
//////    Box(modifier = Modifier.fillMaxSize()) {
//////        Column(
//////            modifier = Modifier
//////                .fillMaxSize()
//////                .padding(bottom = 88.dp, top = 40.dp) // Отступ для BottomAppBar
//////                .padding(20.dp)
//////        ) {
//////            // Header Row
//////            Row(
//////                horizontalArrangement = Arrangement.SpaceAround,
//////                verticalAlignment = Alignment.CenterVertically,
//////                modifier = Modifier.fillMaxWidth()
//////            ) {
//////                IconButton(onClick = {}, modifier = Modifier.size(44.dp)) {
//////                    Image(
//////                        painter = painterResource(R.drawable.menu),
//////                        contentDescription = "Menu",
//////                        contentScale = ContentScale.FillBounds
//////                    )
//////                }
//////
//////                Image(
//////                    modifier = Modifier.size(126.dp, 33.dp),
//////                    painter = painterResource(R.drawable.base),
//////                    contentDescription = "Logo",
//////                    contentScale = ContentScale.FillBounds
//////                )
//////
//////                Image(
//////                    modifier = Modifier.size(44.dp,44.dp),
//////                    painter = painterResource(R.drawable.oc),
//////                    contentDescription = "Cart",
//////                    contentScale = ContentScale.FillBounds
//////                )
//////            }
//////
//////            // Search Row
//////            Row(
//////                modifier = Modifier.fillMaxWidth(),
//////                verticalAlignment = Alignment.CenterVertically
//////            ) {
//////                OutlinedTextField(
//////                    value = searchText,
//////                    onValueChange = { searchText = it },
//////                    modifier = Modifier.weight(1f),
//////                    placeholder = {
//////                        Text(
//////                            text = "Поиск",
//////                            color = Color.Gray
//////                        )
//////                    },
////////                    colors = TextFieldDefaults.textFieldColors(
////////                        containerColor = Color.Transparent,
////////                        focusedIndicatorColor = Color.Transparent,
////////                        unfocusedIndicatorColor = Color.Transparent,
////////                        cursorColor = colorResource(R.color.purple_700)
////////                    ),
//////                    singleLine = true,
//////                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
//////                    keyboardActions = KeyboardActions(onSearch = {})
//////                )
//////
//////                IconButton(
//////                    onClick = {},
//////                    modifier = Modifier.size(25.dp)
//////                ) {
//////                    Image(
//////                        painter = painterResource(R.drawable.mn),
//////                        contentDescription = "Search",
//////                        contentScale = ContentScale.FillBounds
//////                    )
//////                }
//////            }
//////
//////            // Categories Section
//////            Text(
//////                "Категории",
//////                fontSize = 16.sp,
//////                modifier = Modifier.padding(top = 22.dp, bottom = 22.dp)
//////            )
//////
//////            Slider(
//////                items = categories,
//////                selectedCategory = selectedCategory,
//////                onItemSelected = { category ->
//////                    selectedCategory = category
//////                }
//////            )
//////
//////            // Popular Products Section
//////            Row(
//////                modifier = Modifier.fillMaxWidth(),
//////                horizontalArrangement = Arrangement.SpaceBetween,
//////                verticalAlignment = Alignment.CenterVertically
//////            ) {
//////                Text(
//////                    "Популярное",
//////                    fontSize = 16.sp,
//////                    modifier = Modifier.padding(top = 22.dp, bottom = 22.dp)
//////                )
//////
//////                TextButton(onClick = {}) {
//////                    Text("Все", fontSize = 12.sp, color = colorResource(R.color.purple_700))
//////                }
//////            }
//////
//////            // Product Cards
//////            Row(
//////                modifier = Modifier.fillMaxWidth(),
//////                horizontalArrangement = Arrangement.SpaceBetween
//////            ) {
//////                ProductCard()
//////                ProductCard()
//////            }
//////
//////            Row(
//////                modifier = Modifier.fillMaxWidth(),
//////                horizontalArrangement = Arrangement.SpaceBetween,
//////                verticalAlignment = Alignment.CenterVertically
//////            ) {
//////                Text(
//////                    "Специальные предложения",
//////                    fontSize = 16.sp,
//////                    modifier = Modifier.padding(top = 22.dp, bottom = 22.dp)
//////                )
//////
//////                TextButton(onClick = {}) {
//////                    Text("Все", fontSize = 12.sp, color = colorResource(R.color.purple_700))
//////                }
//////            }
//////
//////            // Special Offers
//////            IconButton(
//////                onClick = {},
//////                modifier = Modifier.fillMaxWidth()
//////            ) {
//////                Image(
//////                    modifier = Modifier.size(331.dp, 100.dp),
//////                    painter = painterResource(R.drawable.aks),
//////                    contentDescription = "Special Offers"
//////                )
//////            }
//////        }
//////
//////        // BottomAppBar
//////        BottomAppBar(
//////            modifier = Modifier
//////                .fillMaxWidth()
//////                .height(88.dp)
//////                .align(Alignment.BottomCenter),
//////            containerColor = Color.White,
//////            content = {
//////                Row(
//////                    modifier = Modifier
//////                        .fillMaxWidth()
//////                        .padding(horizontal = 16.dp),
//////                    horizontalArrangement = Arrangement.SpaceBetween,
//////                    verticalAlignment = Alignment.CenterVertically
//////                ) {
//////                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//////                        IconButton(onClick = { /* Домашняя страница */ }) {
//////                            Icon(
//////                                painter = painterResource(R.drawable.ic_home),
//////                                contentDescription = "Главная",
//////                                tint = colorResource(R.color.purple_700)
//////                            )
//////                        }
//////                        Text("Главная", fontSize = 12.sp)
//////                    }
//////
//////                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//////                        IconButton(onClick = { /* Поиск */ }) {
//////                            Icon(
//////                                painter = painterResource(R.drawable.is_search),
//////                                contentDescription = "Поиск",
//////                                tint = Color.Gray
//////                            )
//////                        }
//////                        Text("Поиск", fontSize = 12.sp, color = Color.Gray)
//////                    }
//////
//////                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//////                        IconButton(onClick = { /* Корзина */ }) {
//////                            Icon(
//////                                painter = painterResource(R.drawable.cart),
//////                                contentDescription = "Корзина",
//////                                tint = Color.Gray
//////                            )
//////                        }
//////                        Text("Корзина", fontSize = 12.sp, color = Color.Gray)
//////                    }
//////
//////                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//////                        IconButton(onClick = { /* Избранное */ }) {
//////                            Icon(
//////                                painter = painterResource(R.drawable.icon),
//////                                contentDescription = "Избранное",
//////                                tint = Color.Gray
//////                            )
//////                        }
//////                        Text("Избранное", fontSize = 12.sp, color = Color.Gray)
//////                    }
//////
//////                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//////                        IconButton(onClick = { /* Профиль */ }) {
//////                            Icon(
//////                                painter = painterResource(R.drawable.profile),
//////                                contentDescription = "Профиль",
//////                                tint = Color.Gray
//////                            )
//////                        }
//////                        Text("Профиль", fontSize = 12.sp, color = Color.Gray)
//////                    }
//////                }
//////            }
//////        )
//////    }
//////}
//////@Composable
//////fun ProductCard() {
//////    Card(
//////        modifier = Modifier
//////            .size(width = 162.dp, height = 182.dp)
//////            .padding(bottom = 16.dp),
//////        backgroundColor = colorResource(R.color.white),
//////        shape = RoundedCornerShape(12.dp),
//////        elevation = 4.dp
//////    ) {
//////        Column(
//////            modifier = Modifier.fillMaxSize(),
//////            verticalArrangement = Arrangement.SpaceBetween
//////        ) {
//////            Box(modifier = Modifier.weight(0.7f)) {
//////                Image(
//////                    painter = painterResource(R.drawable.nike),
//////                    contentScale = ContentScale.FillBounds,
//////                    contentDescription = "Product Image",
//////                    modifier = Modifier.fillMaxSize()
//////                )
//////
//////                IconButton(
//////                    onClick = { /* Toggle favorite */ },
//////                    modifier = Modifier
//////                        .size(28.dp)
//////                        .align(Alignment.TopEnd)
//////                ) {
//////                    Image(
//////                        painter = painterResource(R.drawable.iconwhite),
//////                        contentDescription = "Favorite"
//////                    )
//////                }
//////            }
//////
//////            Row(
//////                modifier = Modifier
//////                    .fillMaxWidth()
//////                    .padding(horizontal = 8.dp),
//////                verticalAlignment = Alignment.CenterVertically,
//////                horizontalArrangement = Arrangement.SpaceBetween
//////            ) {
//////                Text("₽752.00", style = MaterialTheme.typography.h6)
//////
//////                IconButton(onClick = { /* Add to cart */ }) {
//////                    Image(
//////                        painter = painterResource(R.drawable.plus),
//////                        contentDescription = "Add to Cart"
//////                    )
//////                }
//////            }
//////        }
//////
//////
//////
//////    }
//////}
////////data class Category(val id: Int, val name: String)
//////
////
////
////
////@OptIn(ExperimentalMaterial3Api::class)
////@Composable
////fun Home(navController: NavController, categories: List<Category>, products: List<Product>) {
////    val categories = remember {
////        listOf(
////            Category(1, "Все"),
////            Category(2, "Outdoor"),
////            Category(3, "Tennis"),
////            Category(4, "Футбол"),
////        )
////    }
////
////    var selectedCategory by remember { mutableStateOf(categories.first()) }
////    var searchText by remember { mutableStateOf("") }
//////    if (categories.isEmpty()) {
//////        Box(
//////            modifier = Modifier.fillMaxSize(),
//////            contentAlignment = Alignment.Center
//////        ) {
//////            CircularProgressIndicator() // Индикатор загрузки
//////            Text("Загрузка категорий...", modifier = Modifier.padding(top = 16.dp))
//////        }
//////        return
//////    }
//////
//////    var selectedCategory by remember { mutableStateOf(categories.first()) }
////    Box(modifier = Modifier.fillMaxSize()) {
////        Column(
////            modifier = Modifier
////                .fillMaxSize()
////                .padding(bottom = 88.dp, top = 40.dp)
////                .padding(20.dp)
////        ) {
////            // Header Row
////            Row(
////                horizontalArrangement = Arrangement.SpaceAround,
////                verticalAlignment = Alignment.CenterVertically,
////                modifier = Modifier.fillMaxWidth()
////            ) {
////                IconButton(onClick = {}, modifier = Modifier.size(44.dp)) {
////                    Image(
////                        painter = painterResource(R.drawable.menu),
////                        contentDescription = "Menu",
////                        contentScale = ContentScale.FillBounds
////                    )
////                }
////
////                Image(
////                    modifier = Modifier.size(126.dp, 33.dp),
////                    painter = painterResource(R.drawable.base),
////                    contentDescription = "Logo",
////                    contentScale = ContentScale.FillBounds
////                )
////
////                Image(
////                    modifier = Modifier.size(44.dp, 44.dp),
////                    painter = painterResource(R.drawable.oc),
////                    contentDescription = "Cart",
////                    contentScale = ContentScale.FillBounds
////                )
////            }
////
////            // Search Row
////            Row(
////                modifier = Modifier.fillMaxWidth(),
////                verticalAlignment = Alignment.CenterVertically
////            ) {
////                OutlinedTextField(
////                    value = searchText,
////                    onValueChange = { searchText = it },
////                    modifier = Modifier.weight(1f),
////                    placeholder = {
////                        Text(
////                            text = "Поиск",
////                            color = Color.Gray
////                        )
////                    },
////                    singleLine = true,
////                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
////                    keyboardActions = KeyboardActions(onSearch = {})
////                )
////
////                IconButton(
////                    onClick = {},
////                    modifier = Modifier.size(25.dp)
////                ) {
////                    Image(
////                        painter = painterResource(R.drawable.mn),
////                        contentDescription = "Search",
////                        contentScale = ContentScale.FillBounds
////                    )
////                }
////            }
////
////            // Categories Section
////            Text(
////                "Категории",
////                fontSize = 16.sp,
////                modifier = Modifier.padding(top = 22.dp, bottom = 22.dp)
////            )
////
////            Slider(
////                items = categories,
////                selectedCategory = selectedCategory,
////                onItemSelected = { category ->
////                    selectedCategory = category
////                    if (category.id == 1) { // "Все" category
////                        navController.navigate("allProducts")
////                    }
////                }
////            )
////
////            // Popular Products Section
////            Row(
////                modifier = Modifier.fillMaxWidth(),
////                horizontalArrangement = Arrangement.SpaceBetween,
////                verticalAlignment = Alignment.CenterVertically
////            ) {
////                Text(
////                    "Популярное",
////                    fontSize = 16.sp,
////                    modifier = Modifier.padding(top = 22.dp, bottom = 22.dp)
////                )
////
////                TextButton(onClick = { navController.navigate("allProducts") }) {
////                    Text("Все", fontSize = 12.sp, color = colorResource(R.color.purple_700))
////                }
////            }
////
////            // Product Cards
////            Row(
////                modifier = Modifier.fillMaxWidth(),
////                horizontalArrangement = Arrangement.SpaceBetween
////            ) {
////                products.filterNotNull().take(2).forEach { product ->
////                    ProductCard(product = product)
////                }
////            }
////
////            // Special Offers Section
////            Row(
////                modifier = Modifier.fillMaxWidth(),
////                horizontalArrangement = Arrangement.SpaceBetween,
////                verticalAlignment = Alignment.CenterVertically
////            ) {
////                Text(
////                    "Специальные предложения",
////                    fontSize = 16.sp,
////                    modifier = Modifier.padding(top = 22.dp, bottom = 22.dp)
////                )
////
////                TextButton(onClick = { navController.navigate("allProducts") }) {
////                    Text("Все", fontSize = 12.sp, color = colorResource(R.color.purple_700))
////                }
////            }
////
////            IconButton(
////                onClick = {},
////                modifier = Modifier.fillMaxWidth()
////            ) {
////                Image(
////                    modifier = Modifier.size(331.dp, 100.dp),
////                    painter = painterResource(R.drawable.aks),
////                    contentDescription = "Special Offers"
////                )
////            }
////        }
////
////        // BottomAppBar
////        BottomAppBar(
////            modifier = Modifier
////                .fillMaxWidth()
////                .height(88.dp)
////                .align(Alignment.BottomCenter),
////            containerColor = Color.White
////        ) {
////            Row(
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(horizontal = 16.dp),
////                horizontalArrangement = Arrangement.SpaceBetween,
////                verticalAlignment = Alignment.CenterVertically
////            ) {
////                Column(horizontalAlignment = Alignment.CenterHorizontally) {
////                    IconButton(onClick = { /* Домашняя страница */ }) {
////                        Icon(
////                            painter = painterResource(R.drawable.ic_home),
////                            contentDescription = "Главная",
////                            tint = colorResource(R.color.purple_700)
////                        )
////                    }
////                    Text("Главная", fontSize = 12.sp)
////                }
////
////                Column(horizontalAlignment = Alignment.CenterHorizontally) {
////                    IconButton(onClick = { /* Поиск */ }) {
////                        Icon(
////                            painter = painterResource(R.drawable.is_search),
////                            contentDescription = "Поиск",
////                            tint = Color.Gray
////                        )
////                    }
////                    Text("Поиск", fontSize = 12.sp, color = Color.Gray)
////                }
////
////                Column(horizontalAlignment = Alignment.CenterHorizontally) {
////                    IconButton(onClick = { /* Корзина */ }) {
////                        Icon(
////                            painter = painterResource(R.drawable.cart),
////                            contentDescription = "Корзина",
////                            tint = Color.Gray
////                        )
////                    }
////                    Text("Корзина", fontSize = 12.sp, color = Color.Gray)
////                }
////
////                Column(horizontalAlignment = Alignment.CenterHorizontally) {
////                    IconButton(onClick = { /* Избранное */ }) {
////                        Icon(
////                            painter = painterResource(R.drawable.icon),
////                            contentDescription = "Избранное",
////                            tint = Color.Gray
////                        )
////                    }
////                    Text("Избранное", fontSize = 12.sp, color = Color.Gray)
////                }
////
////                Column(horizontalAlignment = Alignment.CenterHorizontally) {
////                    IconButton(onClick = { /* Профиль */ }) {
////                        Icon(
////                            painter = painterResource(R.drawable.profile),
////                            contentDescription = "Профиль",
////                            tint = Color.Gray
////                        )
////                    }
////                    Text("Профиль", fontSize = 12.sp, color = Color.Gray)
////                }
////            }
////        }
////    }
////}
//
//package com.example.pr_31
//
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Text
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.pr_31.ui.theme.Pr_31Theme
//import com.google.firebase.FirebaseApp
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.ValueEventListener
//import com.google.firebase.database.ktx.database
//import com.google.firebase.ktx.Firebase
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        FirebaseApp.initializeApp(this)
//
//        setContent {
//            Pr_31Theme {
//                val categories = remember { mutableStateOf(listOf<Category>()) }
//                val products = remember { mutableStateOf(listOf<Product>()) }
//                val error = remember { mutableStateOf<String?>(null) }
//                val isLoading = remember { mutableStateOf(true) }
//
//                loadDataFromFirebase(categories, products, error, isLoading)
//
//                // Обработка состояний загрузки и ошибок
//                when {
//                    isLoading.value -> {
//                        Box(
//                            modifier = Modifier.fillMaxSize(),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            CircularProgressIndicator()
//                            Text("Загрузка данных...", modifier = Modifier.padding(top = 16.dp))
//                        }
//                    }
//
//                    error.value != null -> {
//                        Box(
//                            modifier = Modifier.fillMaxSize(),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Text("Ошибка: ${error.value}")
//                        }
//                    }
//
//                    else -> {
//                        App(categories.value, products.value)
//                    }
//                }
//            }
//        }
//    }
//
//    private fun loadDataFromFirebase(
//        categoriesState: MutableState<List<Category>>,
//        productsState: MutableState<List<Product>>,
//        errorState: MutableState<String?>,
//        isLoadingState: MutableState<Boolean>,
//    ) {
//        try {
//            val database = Firebase.database.reference
//            Log.d("MainActivity", "Firebase database reference initialized")
//
//            database.child("categories")
//                .addListenerForSingleValueEvent(object : ValueEventListener {
//                    override fun onDataChange(snapshot: DataSnapshot) {
//                        val categories =
//                            snapshot.children.mapNotNull { it.getValue(Category::class.java) }
//                        Log.d("MainActivity", "Loaded categories: $categories")
//                        categoriesState.value = categories
//
//                        // Проверяем, загружены ли продукты
//                        if (productsState.value.isNotEmpty()) {
//                            isLoadingState.value = false
//                        }
//                    }
//
//                    override fun onCancelled(error: DatabaseError) {
//                        Log.e("MainActivity", "Error loading categories: ${error.message}")
//                        errorState.value = "Ошибка загрузки категорий: ${error.message}"
//                        isLoadingState.value = false
//                    }
//                })


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
fun Home(navController: NavController, categories: List<Category>, products: List<Product>) {
    var searchText by remember { mutableStateOf("") }

    // Проверка на пустой список категорий
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
            // Header Row
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

                Image(
                    modifier = Modifier.size(44.dp, 44.dp),
                    painter = painterResource(R.drawable.oc),
                    contentDescription = "Cart",
                    contentScale = ContentScale.FillBounds
                )
            }

            // Search Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier.weight(1f),
                    placeholder = {
                        Text(
                            text = "Поиск",
                            color = Color.Gray
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = {})
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier.size(25.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.mn),
                        contentDescription = "Search",
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            // Categories Section
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

            // Popular Products Section
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

            // Product Cards
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                products.filterNotNull().take(2).forEach { product ->
                    ProductCard(product = product)
                }
            }

            // Special Offers Section
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

            IconButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier.size(331.dp, 100.dp),
                    painter = painterResource(R.drawable.aks),
                    contentDescription = "Special Offers"
                )
            }
        }

        // BottomAppBar
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
                    IconButton(onClick = { /* Поиск */ }) {
                        Icon(
                            painter = painterResource(R.drawable.is_search),
                            contentDescription = "Поиск",
                            tint = Color.Gray
                        )
                    }
                    Text("Поиск", fontSize = 12.sp, color = Color.Gray)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = { /* Корзина */ }) {
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