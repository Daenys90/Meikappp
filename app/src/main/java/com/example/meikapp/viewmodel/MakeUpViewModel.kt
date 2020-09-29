package com.example.meikapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.meikapp.model.db.ProductEntity
import com.example.meikapp.model.repository.Repository

class MakeUpViewModel(application: Application) : AndroidViewModel(application){
    val selected = MutableLiveData<ProductEntity>()

    fun select(item: ProductEntity) {
        selected.value = item
    }

    private val repositoryMakeUp = Repository(application)

    val product = repositoryMakeUp.loadApiData()

    val allProduct = repositoryMakeUp.liveDataFromDatabase
}