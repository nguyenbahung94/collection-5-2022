package com.example.buildexample82022.hilt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buildexample82022.hilt.model.Cryptocurrency
import com.example.buildexample82022.hilt.repository.CryptocurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val cryptocurrencyRepository: CryptocurrencyRepository
) : ViewModel() {
    private val _cryptocurrencyEmitter = MutableLiveData<List<Cryptocurrency>>()
    val cryptocurrencyEmitter: LiveData<List<Cryptocurrency>> = _cryptocurrencyEmitter

    init {
        loadCryptocurrency()
    }


    private fun loadCryptocurrency() {
        _cryptocurrencyEmitter.value = cryptocurrencyRepository.getCryptoCurrency()
    }

}