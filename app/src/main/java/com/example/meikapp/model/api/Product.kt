package com.example.meikapp.model.api

data class Product (
    val id: Int,
    val brand: String,
    val name: String,
    val price: Float,
    val price_sign: String,
    val currency: String,
    val link: Link,
    val description: String,
    val rating: String,
    val product_type: String,
    val category: String,
    val tag_list: List<String>,
    val created_at: String,
    val updated_at: String,
    val product_api_url: String,
    val api_featured_image: String,
    val product_colors: Colours,
)