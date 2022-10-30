package com.example.buildexample82022

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp()
class HiltApplication : Application() {


    companion object {
        private var instance: HiltApplication? = null

        fun applicationContext(): HiltApplication {
            return instance as HiltApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}