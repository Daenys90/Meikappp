package com.example.meikapp.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MakeUpDao {

    @Query("SELECT * FROM table_products")
    fun getAllProducts(): LiveData<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(listProduct: List<ProductEntity>)

}