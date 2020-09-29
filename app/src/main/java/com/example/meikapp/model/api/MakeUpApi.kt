package com.example.meikapp.model.api

import retrofit2.Call
import retrofit2.http.GET

interface MakeUpApi {
    @GET("all.json")
    fun allProducts(): Call<List<Product>>

}