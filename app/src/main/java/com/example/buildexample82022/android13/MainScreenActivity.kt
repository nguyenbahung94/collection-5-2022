package com.example.buildexample82022.android13

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
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
import com.example.buildexample82022.appfetchlocationbyfiled.ui.main.ParentActivity
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

        btnFetchLocation.setOnClickListener {
            startActivity(Intent(this, ParentActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        //smart cast
        val str1: String? = "GeeksforGeeks"
        var str2: String? = null   // prints String is null
        if (str1 is String) {

            // No Explicit type Casting needed.
            println("length of String ${str1.length}")
        } else {
            println("String is null")
        }

        var name = "Praveen"
        var age = 24
        var salary = 5000.55
        val employeeDetails: List<Any> = listOf(name, age, salary)

        for (attribute in employeeDetails) {
            if (attribute is String) {
                println("Name: $attribute")
            } else if (attribute is Int) {
                println("Age: $attribute")
            } else if (attribute is Double) {
                println("Salary: $attribute")
            } else {
                println("Not an attribute")
            }
        }

        val person = Person("javax", "20")
        if (person.age is Int) {
            Log.e("person ", "Age is type Int")
        } else {
            Log.e("person ", "Age is not type Int")
        }

        funCheckSmartCast()
    }

    private fun funCheckSmartCast() {
        var str1: Any = "Safe casting"
        val str2: String? = str1 as? String     // it works
        str1 = 11
        // type casting not possible so returns null to str3
        val str3: String? = str1 as? String
        val str4: Int? = str1 as? Int          // it works
        println(str2)
        println(str3)
        println(str4)
    }
}

data class Person(
    val name: String,
    val age: Any
)