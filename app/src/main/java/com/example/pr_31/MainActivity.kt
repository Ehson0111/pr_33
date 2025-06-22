package com.example.pr_31

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pr_31.Screen.AllProductsScreen
import com.example.pr_31.Screen.CartScreen
import com.example.pr_31.Screen.SearchScreen
import com.example.pr_31.ui.theme.Pr_31Theme
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FirebaseApp.initializeApp(this)

        setContent {
            Pr_31Theme {
                val categories = remember { mutableStateOf(listOf<Category>()) }
                val products = remember { mutableStateOf(listOf<Product>()) }
                val cartItems = remember { mutableStateOf(listOf<CartItem>()) }
                val error = remember { mutableStateOf<String?>(null) }
                val isLoading = remember { mutableStateOf(true) }

                loadDataFromFirebase(categories, products, error, isLoading)

                when {
                    isLoading.value -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                            Text("Загрузка данных...", modifier = Modifier.padding(top = 16.dp))
                        }
                    }
                    error.value != null -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Ошибка: ${error.value}")
                        }
                    }
                    else -> {
                        App(categories.value, products.value, cartItems.value) { updatedCart ->
                            cartItems.value = updatedCart
                        }
                    }
                }
            }
        }
    }

    private fun loadDataFromFirebase(
        categoriesState: MutableState<List<Category>>,
        productsState: MutableState<List<Product>>,
        errorState: MutableState<String?>,
        isLoadingState: MutableState<Boolean>
    ) {
        try {
            val database = Firebase.database.reference
            Log.d("MainActivity", "Firebase database reference initialized")

            database.child("categories").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val categories = snapshot.children.mapNotNull { it.getValue(Category::class.java) }
                    categoriesState.value = categories
                    if (productsState.value.isNotEmpty()) isLoadingState.value = false
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("MainActivity", "Error loading categories: ${error.message}")
                    errorState.value = "Ошибка загрузки категорий: ${error.message}"
                    isLoadingState.value = false
                }
            })

            database.child("products").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val products = snapshot.children.mapNotNull { it.getValue(Product::class.java) }
                    productsState.value = products
                    if (categoriesState.value.isNotEmpty()) isLoadingState.value = false
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("MainActivity", "Error loading products: ${error.message}")
                    errorState.value = "Ошибка загрузки продуктов: ${error.message}"
                    isLoadingState.value = false
                }
            })
        } catch (e: Exception) {
            Log.e("MainActivity", "Exception in loadDataFromFirebase: ${e.message}", e)
            errorState.value = "Исключение при загрузке данных: ${e.message}"
            isLoadingState.value = false
        }
    }

    @Composable
    fun App(categories: List<Category>, products: List<Product>, cartItems: List<CartItem>, onCartUpdate: (List<CartItem>) -> Unit) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "SignUp") {
            composable("SignUp") {
                SignUp(navController = navController)
            }
            composable("home") {
                Home(
                    navController = navController,
                    categories = categories,
                    products = products,
                    onAddToCart = { product ->
                        val existing = cartItems.find { it.product.id == product.id }
                        val updatedCart = if (existing != null) {
                            cartItems.toMutableList().apply { this[cartItems.indexOf(existing)].count += 1 }
                        } else {
                            cartItems.toMutableList().apply { add(CartItem(product, 1)) }
                        }
                        onCartUpdate(updatedCart)
                    }
                )
            }
            composable("allProducts") {
                AllProductsScreen(
                    navController = navController,
                    products = products,
                    onAddToCart = { product ->
                        val existing = cartItems.find { it.product.id == product.id }
                        val updatedCart = if (existing != null) {
                            cartItems.toMutableList().apply { this[cartItems.indexOf(existing)].count += 1 }
                        } else {
                            cartItems.toMutableList().apply { add(CartItem(product, 1)) }
                        }
                        onCartUpdate(updatedCart)
                    }
                )
            }
            composable("cart") {
                CartScreen(
                    navController = navController,
                    cartItems = cartItems,
                    onCartUpdate = { updatedCart ->
                        onCartUpdate(updatedCart)
                    }
                )
            }
            composable("search") {
                SearchScreen(
                    navController = navController,
                    products = products,
                    onAddToCart = { product ->
                        val existing = cartItems.find { it.product.id == product.id }
                        val updatedCart = if (existing != null) {
                            cartItems.toMutableList().apply { this[cartItems.indexOf(existing)].count += 1 }
                        } else {
                            cartItems.toMutableList().apply { add(CartItem(product, 1)) }
                        }
                        onCartUpdate(updatedCart)
                    }
                )
            }
        }
    }
}