package com.example.buildexample82022.mvvm.data.api

import com.example.buildexample82022.mvvm.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}