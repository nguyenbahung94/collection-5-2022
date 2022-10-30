package com.example.buildexample82022.hilt.repository

import com.example.buildexample82022.hilt.model.Cryptocurrency

interface CryptocurrencyRepository {
    fun getCryptoCurrency(): List<Cryptocurrency>
}