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

class Test2: Fragment() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        event()
    }

    private fun init() {

    }

    private fun event() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

<<<<<<< HEAD
    companion object {
        fun newInstance(): temp {
            return temp().apply {
                arguments = Bundle().apply {
                }
            }
        }
=======
    fun newInstance(): Test2 {
        return Test2().apply {
            arguments = Bundle().apply {
            }
        }
    }
}

class   Test3 :Fragment() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        event()
    }

    private fun init() {
>>>>>>> check_style_code_pull_request

    }

    private fun event() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun newInstance(): Test3 {
        return Test3().apply {
            arguments = Bundle().apply {
            }
        }
    }
}

