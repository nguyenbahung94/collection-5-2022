package com.example.buildexample82022.android13

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.buildexample82022.R
import com.example.buildexample82022.android12.splashscreen.MainActivityAndroid12
import com.example.buildexample82022.android13.coppypast.MainCoppyPastActivity
import com.example.buildexample82022.android13.nearwifidevices.NearWifiDevicesActivity
import com.example.buildexample82022.android13.notification_runtime_permisson.NotificationRuntimePermissionActivity
import com.example.buildexample82022.android13.per_app_language_preferences.PerAppLanguagePreferencesActivity
import com.example.buildexample82022.android13.photo_picker.PhotoPickerActivity
import com.example.buildexample82022.android13.predictivebackgesture.MainPreDictiveBackGestureActivity
import com.example.buildexample82022.android13.programmableShaders.ProgrammableShadersActivity
import com.example.buildexample82022.android13.quicksetting.QuickSettingActivity
import com.example.buildexample82022.android13.removepermission.MainRemovePermissionActivity
import com.example.buildexample82022.composeCourse.FirstComposeMainActivity
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
        btnCompose.setOnClickListener {
            startActivity(Intent(this,FirstComposeMainActivity::class.java))
        }

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
            startActivity(Intent(this, MainRemovePermissionActivity::class.java))
        }
        btnNearWifiDevices.setOnClickListener {
            startActivity(Intent(this, NearWifiDevicesActivity::class.java))
        }
        btnNotificationRuntimePermission.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startActivity(Intent(this, NotificationRuntimePermissionActivity::class.java))
            }
        }
        btnPerLanguagePreferences.setOnClickListener {
            startActivity(Intent(this, PerAppLanguagePreferencesActivity::class.java))
        }

        btnPhotoPicker.setOnClickListener {
            startActivity(Intent(this, PhotoPickerActivity::class.java))
        }

        btnPredictiveBackGesture.setOnClickListener {
            startActivity(Intent(this, MainPreDictiveBackGestureActivity::class.java))
        }

        btnProgrammableShader.setOnClickListener {
            startActivity(Intent(this, ProgrammableShadersActivity::class.java))
        }

        btnQuickSetting.setOnClickListener {
            startActivity(Intent(this, QuickSettingActivity::class.java))
        }
        btnAndroid12.setOnClickListener {
            startActivity(Intent(this, MainActivityAndroid12::class.java))
        }


    }
}