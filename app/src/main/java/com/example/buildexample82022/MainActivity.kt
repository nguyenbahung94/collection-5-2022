package com.example.buildexample82022

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buildexample82022.appfetchlocationbyfiled.api.model.Main
import com.example.buildexample82022.databinding.ActivityMainBinding
import com.example.buildexample82022.databinding.MainScreenActivityBinding
import com.example.buildexample82022.utils.newIntent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    companion object {

        fun startActivity(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java).apply {
            })
        }
    }
}

