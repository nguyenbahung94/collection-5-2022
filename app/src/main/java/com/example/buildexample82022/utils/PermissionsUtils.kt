package com.example.buildexample82022.utils

import android.Manifest
import android.content.pm.PackageManager
import android.app.Activity
import android.content.Context
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionsUtils {
    const val REQUEST_STORAGE = 0
    const val REQUEST_LOCATION = 1
    const val REQUEST_CAMERA = 2
    const val REQUEST_AUDIO_RECORD = 3
    const val REQUEST_CONTACT = 4
    const val REQUEST_CAMERA_AUDIO = 5
    @JvmField
    var PERMISSIONS_LOCATION = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
    @JvmField
    var PERMISSIONS_STORAGE = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    @JvmField
    var PERMISSIONS_RECORD_AUDIO = arrayOf(Manifest.permission.RECORD_AUDIO)
    @JvmField
    var PERMISSION_CAMERA = arrayOf(Manifest.permission.CAMERA)
    @JvmField
    var PERMISSION_CONTACT = arrayOf(Manifest.permission.READ_CONTACTS)
    @JvmStatic
    fun verifyPermissions(grantResults: IntArray): Boolean {
        if (grantResults.isEmpty()) {
            return false
        }
        for (result in grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    fun shouldShowRequestForLocationPermission(activity: Activity?): Boolean {
        return (ActivityCompat.shouldShowRequestPermissionRationale(
            activity!!,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
                || ActivityCompat.shouldShowRequestPermissionRationale(
            activity,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))
    }

    fun shouldShowRequestForAudioPermission(activity: Activity?): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(
            activity!!,
            Manifest.permission.RECORD_AUDIO
        )
    }

    fun shouldShowRequestForStoragePermission(activity: Activity?): Boolean {
        return (ActivityCompat.shouldShowRequestPermissionRationale(
            activity!!,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
                || ActivityCompat.shouldShowRequestPermissionRationale(
            activity,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ))
    }

    fun shouldShowRequestForCallPermission(activity: Activity?): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(
            activity!!,
            Manifest.permission.CALL_PHONE
        )
    }

    fun shouldShowRequestForCameraPermission(activity: Activity?): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(
            activity!!,
            Manifest.permission.CAMERA
        )
    }

    fun shouldShowRequestForContactPermission(activity: Activity?): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(
            activity!!,
            Manifest.permission.READ_CONTACTS
        )
    }

    fun shouldShowRequestForVideoPermission(activity: Activity?): Boolean {
        return (ActivityCompat.shouldShowRequestPermissionRationale(
            activity!!,
            Manifest.permission.CAMERA
        )
                && ActivityCompat.shouldShowRequestPermissionRationale(
            activity,
            Manifest.permission.RECORD_AUDIO
        ))
    }

    @JvmStatic
    fun checkSelfForStoragePermission(activity: Activity?): Boolean {
        return (ActivityCompat.checkSelfPermission(
            activity!!,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(
            activity,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
                != PackageManager.PERMISSION_GRANTED)
    }

    @JvmStatic
    fun checkSelfPermissionForLocation(activity: Activity?): Boolean {
        return (ActivityCompat.checkSelfPermission(
            activity!!,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(
            activity,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
                != PackageManager.PERMISSION_GRANTED)
    }

    @JvmStatic
    fun checkSelfPermissionForAudioRecording(activity: Activity?): Boolean {
        return (ActivityCompat.checkSelfPermission(activity!!, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED)
    }

    fun checkSelfForCallPermission(activity: Activity?): Boolean {
        return (ActivityCompat.checkSelfPermission(activity!!, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED)
    }

    @JvmStatic
    fun checkSelfForCameraPermission(activity: Activity?): Boolean {
        return (ActivityCompat.checkSelfPermission(activity!!, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED)
    }

    @JvmStatic
    fun checkSelfForContactPermission(activity: Activity?): Boolean {
        return (ActivityCompat.checkSelfPermission(activity!!, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED)
    }

    @JvmStatic
    fun requestPermissions(activity: Activity?, permissions: Array<String>, requestCode: Int) {
        ActivityCompat.requestPermissions(activity!!, permissions, requestCode)
    }

    @JvmStatic
    fun isAudioRecordingPermissionGranted(context: Context): Boolean {
        val permission = "android.permission.RECORD_AUDIO"
        val res = context.checkCallingOrSelfPermission(permission)
        return res == PackageManager.PERMISSION_GRANTED
    }

    @JvmStatic
    fun isCameraPermissionGranted(context: Context): Boolean {
        val res = context.checkCallingOrSelfPermission(Manifest.permission.CAMERA)
        return res == PackageManager.PERMISSION_GRANTED
    }

    fun isCallPermissionGranted(context: Context): Boolean {
        val res = context.checkCallingOrSelfPermission(Manifest.permission.CALL_PHONE)
        return res == PackageManager.PERMISSION_GRANTED
    }

    @JvmStatic
    fun checkPermissionForCameraAndMicrophone(context: Context?): Boolean {
        val resultCamera = ContextCompat.checkSelfPermission(context!!, Manifest.permission.CAMERA)
        val resultMic = ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO)
        return !(resultCamera == PackageManager.PERMISSION_GRANTED &&
                resultMic == PackageManager.PERMISSION_GRANTED)
    }

    @JvmStatic
    fun isStoragePermissionGranted(context: Context): Boolean {
        val resWrite =
            context.checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val resRead =
            context.checkCallingOrSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
        return resWrite == PackageManager.PERMISSION_GRANTED && resRead == PackageManager.PERMISSION_GRANTED
    }
}