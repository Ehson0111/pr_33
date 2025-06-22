package com.example.pr_31


import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Product(
    val id: Int = 0,
    val category_id: Int = 0,
    val name: String = "",
    val description: String = "",
    val image: String = "",
    val price_current: Int = 0,

) {
    // Конструктор без аргументов
    constructor() : this(0, 0, "", "", "", 0, )
}