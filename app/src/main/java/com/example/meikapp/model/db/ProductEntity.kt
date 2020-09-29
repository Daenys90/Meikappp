package com.example.meikapp.model.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.meikapp.model.api.Colours
import com.example.meikapp.model.api.Link

@Entity(tableName = "table_products")
data class ProductEntity(
@PrimaryKey val id: Int,
    val brand: String,
    val name: String,
    val price: Float,
    val price_sign: String,
    val currency: String,
    @Embedded  val link: Link,
    val description: String,
    val rating: String,
    val product_type: String,
    val category: String,
    val tag_list: List<String>,
    val created_at: String,
    val updated_at: String,
    val product_api_url: String,
    val api_featured_image: String,
    @Embedded val product_colors: Colours,
    )
