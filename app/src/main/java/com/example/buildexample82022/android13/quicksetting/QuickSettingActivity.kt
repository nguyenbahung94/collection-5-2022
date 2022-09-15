package com.example.buildexample82022.android13.quicksetting

import android.annotation.SuppressLint
import android.app.StatusBarManager
import android.content.ComponentName
import android.content.Context
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.buildexample82022.R

class QuickSettingActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_setting)

        findViewById<Button>(R.id.button_add_quick_settings).setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val statusBarManager =
                    getSystemService(Context.STATUS_BAR_SERVICE) as StatusBarManager
                /**
                 * Important: Change the package name accordingly to your own package name!
                 */
                statusBarManager.requestAddTileService(
                    ComponentName(
                        "com.example.buildexample82022.android13.quicksetting",
                        "com.example.buildexample82022.android13.quicksetting.StartAppTileService",
                    ),
                    "My App test 13",
                    Icon.createWithResource(this, R.drawable.ic_launcher_foreground),
                    {},
                    {}
                )
            } else {
                Toast.makeText(
                    this,
                    "`requestAddTileService` can only be called in Android 13/Tiramisu.",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
    }
}