package com.example.buildexample82022.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.buildexample82022.appfetchlocationbyfiled.ui.main.ParentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


inline fun <reified T : Any> Context.launchActivity(
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent, options)
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

/***
 *  Set the View visibility to visible
 */
fun View.visible() {
    this.visibility = View.VISIBLE
}

/***
 *  Set the View visibility to gone
 */
fun View.gone() {
    this.visibility = View.GONE
}

/**
 * Launches a new coroutine and repeats `block` every time the Fragment's viewLifecycleOwner
 * is in and out of `minActiveState` lifecycle state.
 */
inline fun Fragment.launchAndRepeatWithViewLifecycle(
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline block: suspend CoroutineScope.() -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(minActiveState) {
            block()
        }
    }
}

/***
 *  Extension function to check if location permissions are granted
 */
fun Context.hasLocationPermission() = ActivityCompat.checkSelfPermission(
    this,
    ParentActivity.FINE_LOCATION_PERMISSION
) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
    this,
    ParentActivity.COARSE_LOCATION_PERMISSION
) == PackageManager.PERMISSION_GRANTED

/***
 *  Extension function to check if GPS is enabled
 */
fun Context.isGpsEnabled(): Boolean {
    val mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
    return mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
}