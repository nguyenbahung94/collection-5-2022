package com.example.buildexample82022.mvvm.data.api

import com.example.buildexample82022.mvvm.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}