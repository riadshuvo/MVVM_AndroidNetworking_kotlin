package com.example.mvvm_architecture_beginners.data.api

import com.example.mvvm_architecture_beginners.data.model.User
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>

}