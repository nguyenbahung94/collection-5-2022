package com.example.buildexample82022.android13

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.buildexample82022.R
import com.example.buildexample82022.android13.coppypast.MainCoppyPastActivity
import com.example.buildexample82022.hilt.MainHiltActivity
import com.example.buildexample82022.mvvm.ui.view.MainActivityMVVM
import kotlinx.android.synthetic.main.main_screen_activity.*

class MainScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen_activity)
        setOnClick()
    }

    private fun setOnClick() {
        btnHilt.setOnClickListener {
            startActivity(Intent(this, MainHiltActivity::class.java))
        }
        btnmvvm.setOnClickListener {
            startActivity(Intent(this, MainActivityMVVM::class.java))
        }
        btnCoppyPast.setOnClickListener {
            startActivity(Intent(this, MainCoppyPastActivity::class.java))
        }
        btnRemovePermission.setOnClickListener {

        }
    }
}