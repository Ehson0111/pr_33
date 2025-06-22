package com.example.pr_31

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
        FirebaseApp.initializeApp(this) // инициализация Firebase

        setContent {



            val categories = remember { mutableStateOf(listOf<Category>()) }
            val products = remember { mutableStateOf(listOf<Product>()) }
            val error = remember { mutableStateOf<String?>(null) }
            val isLoading = remember { mutableStateOf(true) }
//            val catalogueViewModel:  = viewModel()

            loadDataFromFirebase(categories, products, error, isLoading)

            // Классифицируем все продукты после загрузки


            // После загрузки продуктов запускается их классификация через CatalogueViewModel
//            LaunchedEffect(products.value) {
//                if (products.value.isNotEmpty()) {
//                    catalogueViewModel.classifyAllProducts(products.value)
//                }
//            }




                App()
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
//            Log.d("MainActivity", "Firebase database reference initialized")

            database.child("categories")
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
//                        Log.d("MainActivity", "Categories snapshot: $snapshot")snapshot все данные из узла
                        val categories = snapshot.children.mapNotNull { it.getValue(Category::class.java) }
//                        Log.d("MainActivity", "Loaded categories: $categories")
                        categoriesState.value = categories

                        if (productsState.value.isNotEmpty()) {
                            isLoadingState.value = false
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
//                        Log.e("MainActivity", "Error loading categories: ${error.message}")
                        errorState.value = "Ошибка загрузки категорий: ${error.message}"
                        isLoadingState.value = false
                    }
                })

            database.child("products").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
//                    Log.d("MainActivity", "Products snapshot: $snapshot")
                    val products = snapshot.children.mapNotNull { it.getValue(Product::class.java) }
//                    Log.d("MainActivity", "Loaded products: $products")
                    productsState.value = products

                    if (categoriesState.value.isNotEmpty()) {
                        isLoadingState.value = false
                    }
                }

                override fun onCancelled(error: DatabaseError) {
//                    Log.e("MainActivity", "Error loading products: ${error.message}")
                    errorState.value = "Ошибка загрузки продуктов: ${error.message}"
                    isLoadingState.value = false
                }
            })
        } catch (e: Exception) {
//            Log.e("MainActivity", "Exception in loadDataFromFirebase: ${e.message}", e)
            errorState.value = "Исключение при загрузке данных: ${e.message}"
            isLoadingState.value = false
        }
    }


    @Composable
    fun App(


    ){



        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "SignUp") {
            composable("SignUp") {
                SignUp(navController = navController)
            }
            composable("home") {
                Home(navController = navController)
            }

        }


    }
}


