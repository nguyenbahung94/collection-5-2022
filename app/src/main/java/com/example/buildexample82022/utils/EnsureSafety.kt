package com.example.buildexample82022.utils

import android.app.Activity
import androidx.fragment.app.Fragment

fun Activity.safeRunOnUiThread(action: Runnable) {
    if (this.isFinishing || this.isDestroyed) return
    runOnUiThread(action)
}

fun Fragment.safeRunOnUiThread(action: () -> Unit) {
    if (this.isDetached || this.isRemoving || this.isHidden) return
    activity?.safeRunOnUiThread Foo@ {
        if (this.isDetached || this.isRemoving || this.isHidden) return@Foo
        action()
    }
}

fun Fragment.safeRun(action: () -> Unit) {
    if (this.isDetached || this.isRemoving || this.isHidden) return
    action()
}