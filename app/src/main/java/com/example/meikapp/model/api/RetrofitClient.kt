package com.example.meikapp.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://makeup-api.herokuapp.com/api/v1/products.json"

class RetrofitClient {
    companion object{
        fun retrofitInstance(): MakeUpApi{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(MakeUpApi::class.java)
        }
    }
}