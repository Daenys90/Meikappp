package com.example.meikapp.model.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.meikapp.model.api.Product
import com.example.meikapp.model.api.RetrofitClient
import com.example.meikapp.model.db.MakeUpDatabase
import com.example.meikapp.model.db.ProductEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(context: Context) {

    var listProduct = MutableLiveData<List<Product>>()
    val dao = MakeUpDatabase.getDatabase(context).getMakeUpDao()

    val liveDataFromDatabase = dao.getAllProducts()

    fun loadApiData() {
        val call: Call<List<Product>> = RetrofitClient.retrofitInstance().allProducts()
        call.enqueue(object : Callback<List<Product>> {
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("Adapter", "Error de carga")
            }

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                Log.d("Adapter", "${response.code()}")
                Log.d("Adapter", "${response.body()}")

                listProduct.value = response.body()
                dao.insertProducts(productConvert(response.body()!!))
            }
        })
    }

    fun productConvert(listProduct: List<Product>): List<ProductEntity> {
        return listProduct.map { product ->
            ProductEntity(
                product.id,
                product.brand,
                product.name,
                product.price,
                product.price_sign,
                product.currency,
                product.link,
                product.description,
                product.rating,
                product.product_type,
                product.category,
                product.tag_list,
                product.created_at,
                product.updated_at,
                product.product_api_url,
                product.api_featured_image,
                product.product_colors,
            )
        }
    }
}