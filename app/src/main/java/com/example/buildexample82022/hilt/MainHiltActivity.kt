package com.example.buildexample82022.hilt

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buildexample82022.R
import com.example.buildexample82022.hilt.adapter.CryptocurrencyAdapter
import com.example.buildexample82022.hilt.model.Cryptocurrency
import com.example.buildexample82022.hilt.viewmodel.MainViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainHiltActivity : AppCompatActivity() {

    private lateinit var cryptocurrencyList: RecyclerView
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hilt)
        cryptocurrencyList = findViewById(R.id.cryptocurrency_list)
        cryptocurrencyList.layoutManager = LinearLayoutManager(this)

        observeCryptoCurrency()
    }

    private fun observeCryptoCurrency() {
        viewModel.cryptocurrencyEmitter.observe(this) {
            cryptocurrencyList.adapter = CryptocurrencyAdapter(it)
        }
    }
}