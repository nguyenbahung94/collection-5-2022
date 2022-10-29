package com.example.buildexample82022.utils

import android.app.ActivityManager
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.os.PowerManager
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.buildexample82022.R
import com.example.buildexample82022.appfetchlocationbyfiled.ui.main.ParentActivity
import kotlinx.android.synthetic.main.toast_error_view.view.*
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


val Context.notificationManager: NotificationManager
    get() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
val Context.connectivityManager: ConnectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
val Context.powerManager: PowerManager
    get() = getSystemService(Context.POWER_SERVICE) as PowerManager
val Context.activityManager: ActivityManager
    get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
val Context.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this)

fun Context.hasNetworkConnection(): Boolean {
    val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
    return networkInfo?.isConnected == true
}

fun Context.getRDrawable(resId: Int): Drawable? {
    return ContextCompat.getDrawable(this, resId)
}

fun Context.getRColor(resId: Int): Int {
    return ContextCompat.getColor(this, resId)
}

fun Context.getDimens(value: Float): Int {
    val metrics = this.resources.displayMetrics
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        if (value >= 0) value else 0f,
        metrics
    ).toInt()
}

fun Context.toastError(
    message: String? = null,
    duration: Int = Toast.LENGTH_SHORT,
    crossActivities: Boolean = false
) {
    val layoutInflater = LayoutInflater.from(this)
    val view = layoutInflater.inflate(R.layout.toast_error_view, null)
    view.tvMessage.text = message ?: getString(R.string.tv_da_co_loi)
    val toast = Toast(if (crossActivities) applicationContext else this)
    toast.view = view
    toast.duration = duration
    toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 30)
    toast.show()
}

fun Context.toastSuccess(
    message: String? = null,
    duration: Int = Toast.LENGTH_SHORT,
    crossActivities: Boolean = false
) {
    val layoutInflater = LayoutInflater.from(this)
    val view = layoutInflater.inflate(R.layout.toast_success_view, null)
    view.tvMessage.text = message ?: getString(R.string.tv_da_co_loi)
    val toast = Toast(if (crossActivities) applicationContext else this)
    toast.view = view
    toast.duration = duration
    toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 30)
    toast.show()
}

fun Context.toastWarning(
    message: String? = null,
    duration: Int = Toast.LENGTH_SHORT,
    crossActivities: Boolean = false
) {
    val layoutInflater = LayoutInflater.from(this)
    val view = layoutInflater.inflate(R.layout.toast_warning_view, null)
    view.tvMessage.text = message ?: getString(R.string.tv_da_co_loi)
    val toast = Toast(if (crossActivities) applicationContext else this)
    toast.view = view
    toast.duration = duration
    toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 30)
    toast.show()
}

fun Context.toastCenter(
    message: String? = null,
    duration: Int = Toast.LENGTH_SHORT,
    colorBackground: Int = R.color.pure_black,
    crossActivities: Boolean = false,
) {
    val layoutInflater = LayoutInflater.from(this)
    val view = layoutInflater.inflate(R.layout.toast_custom_view, null)
    view.tvMessage.text = message ?: ""
    view.ll_background.setBackgroundResource(colorBackground)
    val toast = Toast(if (crossActivities) applicationContext else this)
    toast.view = view
    toast.duration = duration
    toast.setGravity(Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL, 0, 30)
    toast.show()
}
