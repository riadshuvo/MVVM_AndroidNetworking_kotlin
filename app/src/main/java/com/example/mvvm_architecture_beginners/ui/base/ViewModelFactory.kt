package com.example.mvvm_architecture_beginners.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_architecture_beginners.data.api.ApiHelper
import com.example.mvvm_architecture_beginners.data.reposotory.MainRepository

import com.example.mvvm_architecture_beginners.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}