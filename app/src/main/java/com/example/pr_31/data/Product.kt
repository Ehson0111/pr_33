package com.example.pr_31

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Product(
    val carbohydrates_per_100_grams: Float? = null,
    val category_id: Int? = null,
    val description: String? = null,
    val energy_per_100_grams: Float? = null,
    val fats_per_100_grams: Float? = null,
    val id: Int? = null,
    val image: String? = null,
    val measure: Int? = null,
    val measure_unit: String? = null,
    val name: String? = null,
    val price_current: Int? = null
)