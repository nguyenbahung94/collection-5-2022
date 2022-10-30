package com.example.buildexample82022.mvvm.data.repository

import com.example.buildexample82022.mvvm.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getUser() = apiHelper.getUsers()
}