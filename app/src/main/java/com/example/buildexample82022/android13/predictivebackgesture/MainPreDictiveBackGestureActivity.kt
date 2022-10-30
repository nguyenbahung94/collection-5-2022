package com.example.buildexample82022.android13.predictivebackgesture

import android.os.Build
import android.os.Bundle
import android.window.OnBackInvokedCallback
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.buildexample82022.R

class MainPreDictiveBackGestureActivity:AppCompatActivity() {

    private lateinit var onBackInvokedCallback: OnBackInvokedCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_dictive_back_gesture)

        // For Non-AndroidX:
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            onBackInvokedCallback = OnBackInvokedCallback {
                // Your app's onBackPressed logic goes here...
            }
            onBackInvokedDispatcher.registerOnBackInvokedCallback(
                OnBackInvokedDispatcher.PRIORITY_DEFAULT,
                onBackInvokedCallback,
            )
        }
        // For AndroidX:
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Your app's onBackPressed logic goes here...
            }
        }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        // You can enable/disable onBackPressedCallback by using `isEnabled` method:
        // onBackPressedCallback.isEnabled = false
    }

    override fun onDestroy() {
        super.onDestroy()

        // For Non-AndroidX:
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            onBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback)
        }
    }
}