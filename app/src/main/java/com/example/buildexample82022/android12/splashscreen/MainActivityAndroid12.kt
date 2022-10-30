package com.example.buildexample82022.android12.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.buildexample82022.R
import com.example.buildexample82022.android12.splashscreen.roundedCornerApi.RoundedConnerApiActivity
import kotlinx.android.synthetic.main.activity_android_12.*

class MainActivityAndroid12 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_12)

        btnSplashScreen.setOnClickListener {
            startActivity(Intent(this, SplashScreenActivity::class.java))
        }
        btnRoundedConnerApi.setOnClickListener {
            startActivity(Intent(this, RoundedConnerApiActivity::class.java))
        }
    }
}