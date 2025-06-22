package com.example.pr_31.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pr_31.Product


//class CartViewModel(private val catalogueViewModel: CatalogueViewModel) : ViewModel() {
class CartViewModel() : ViewModel() {

    private var _cart by mutableStateOf<Map< Product, Int >>(emptyMap())
    val cart: Map<Product, Int>
        get() = _cart

//        val cart = mutableStateMapOf<Product, Int>()


    fun addToCart(product: Product, count: Int) {
        val currentCount = _cart[product] ?: 0 //Если продукта нет в корзине, возвращается 0 (оператор ?: — Elvis-оператор).
//        val newCount = (currentCount + count).coerceAtLeast(0)
        val newCount = maxOf(currentCount + count, 0)

        val newCart = if (newCount > 0) {
            _cart.toMutableMap().apply { put(product, newCount) }
        } else {
            _cart.toMutableMap().apply { remove(product)  }
        }
        _cart = newCart
//        catalogueViewModel.updateCart(_cart)
//        catalogueViewModel.classifyProduct(product)
    }

    fun getItemCount(product: Product): Int {
        return _cart[product] ?: 0
    }
//    fun clearCart() {
//        cart.clear()
//    }


 }
//package com.example.kursobvoy.viewmodel
//
//import androidx.compose.runtime.mutableStateMapOf
//import androidx.lifecycle.ViewModel
//import com.example.kursobvoy.Screens.Product
//
//class CartViewModel : ViewModel() {
//    val cart = mutableStateMapOf<Product, Int>()
//
//    fun addToCart(product: Product) {
//        cart[product] = cart.getOrDefault(product, 0) + 1
//    }
//
//    fun removeFromCart(product: Product) {
//        val count = cart[product] ?: 0
//        if (count > 1) {
//            cart[product] = count - 1
//        } else {
//            cart.remove(product)
//        }
//    }
//
//    fun clearCart() {
//        cart.clear()
//    }
//}