package com.example.meikapp.model.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MakeUpApi {
    @GET("api/v1/products.json")
    fun allProducts(): Call<List<Product>>
   // fun getProductByName(@Query(value = "Producto") name: String): ListProduct

}