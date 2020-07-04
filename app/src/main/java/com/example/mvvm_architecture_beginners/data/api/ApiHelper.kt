package com.example.mvvm_architecture_beginners.data.api

class ApiHelper(private val apiService: ApiService) {
    fun getUsers() = apiService.getUsers()

}