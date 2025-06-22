//package com.example.kursobvoy.Screens
//
//import androidx.compose.ui.text.toLowerCase
//import com.example.pr_31.Category
//import com.example.pr_31.Product
//
//fun filterProductsByCategory(
//    products: List<Product>,
//    category: Category,
//    selectedFilters: Set<Int>,
//    searchText: String,
////    catalogueViewModel: CatalogueViewModel
//): List<Product> {
//    return when (category.id) {
//        // Категория "Все" (ID = 1)
////        1 -> {
////            products.filter { product ->
//                 1. Применяем поиск, если есть текст
////                val matchesSearch = searchText.isEmpty() ||
//                        product.name.contains(searchText, ignoreCase = true) ||
////                        product.name.trim().contains(searchText.trim(), ignoreCase = true) ||
////                        product.description.trim().contains(searchText.trim(), ignoreCase = true)
////
//                 2. Применяем фильтры, если они выбраны
//                val matchesFilters = selectedFilters.isEmpty() ||
//                        product.tag_ids.any { it in selectedFilters }
////
//                matchesSearch && matchesFilters
//            }
//        }
//
//        // Специальная категория (рекомендации)
////        676153 -> {
////            val specialCategoryProductIds = catalogueViewModel.getProductsForSpecialCategory()
////
////            products.filter { product ->
////                product.id in specialCategoryProductIds && (
////                        searchText.isEmpty() ||
////                                product.name.contains(searchText, ignoreCase = true) ||
////                                product.description.contains(searchText, ignoreCase = true)
////                        )
////            }
////        }
//
//        // Все остальные категории
////        else -> {
////            products.filter { product ->
////                 1. Совпадает ли категория
////                val matchesCategory = product.category_id == category.id
////
////                 2. Применяем поиск, если есть текст
////                val matchesSearch = searchText.isEmpty() ||
////                        product.name.contains(searchText, ignoreCase = true) ||
////                        product.description.contains(searchText, ignoreCase = true)
////
////                 3. Применяем фильтры, если они выбраны
////                val matchesFilters = selectedFilters.isEmpty() ||
////                        product.tag_ids.any { it in selectedFilters }
//
////                matchesCategory && matchesSearch && matchesFilters
////            }
//
//        }
//    }
//}
