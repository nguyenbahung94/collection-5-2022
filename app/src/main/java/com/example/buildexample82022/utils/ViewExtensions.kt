package com.example.buildexample82022.utils

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.Shape
import android.os.Build
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.buildexample82022.R

fun View.preventMultiClick() {
    isEnabled = false
    postDelayed({
        isEnabled = true
    }, 500)
}

fun View.preventLongMultiClick() {
    isEnabled = false
    postDelayed({
        isEnabled = true
    }, 1000)
}

fun TextView.setRTextColor(resId: Int) {
    setTextColor(context.getRColor(resId)!!)
}

fun ImageView.networkImage(
    url: String?,
    @DrawableRes defaultImage: Int = R.drawable.ic_placeholder
) {
    if (url.isNullOrEmpty()) {
        Glide.with(context).load(defaultImage).into(this)
    } else {
        val urlImage =
            if (url.contains("https://") or url.contains("http://")) url else "https://$url"

        Glide.with(context)
            .load(urlImage)
            .error(defaultImage)
            .placeholder(defaultImage)
            .into(this)
    }
}

fun ImageView.networkImage(
    url: String?,
    name: String,
    size: Int, // size in dp of this ImageView
    @ColorRes textColor: Int = R.color.white,
    @ColorRes bgColor: Int = R.color.bg_avatar
) {
    val drawable = textDrawable(context, size, textColor, bgColor, name) ?: return
    if (url.isNullOrEmpty()) {
        Glide.with(context).load(drawable).into(this)
        return
    }
    val urlImage =
        if (url.contains("https://") or url.contains("http://")) url else "https://$url"

    Glide.with(context)
        .load(urlImage)
        .error(drawable)
        .placeholder(drawable)
        .into(this)
}

fun View.focusAndShowKeyboard() {
    /**
     * This is to be called when the window already has focus.
     */
    fun View.showTheKeyboardNow() {
        if (isFocused) {
            post {
                // We still post the call, just in case we are being notified of the windows focus
                // but InputMethodManager didn't get properly setup yet.
                val imm =
                    context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
            }
        }
    }

    requestFocus()
    if (hasWindowFocus()) {
        // No need to wait for the window to get focus.
        showTheKeyboardNow()
    } else {
        // We need to wait until the window gets focus.
        viewTreeObserver.addOnWindowFocusChangeListener(
            object : ViewTreeObserver.OnWindowFocusChangeListener {
                override fun onWindowFocusChanged(hasFocus: Boolean) {
                    // This notification will arrive just before the InputMethodManager gets set up.
                    if (hasFocus) {
                        this@focusAndShowKeyboard.showTheKeyboardNow()
                        // It’s very important to remove this listener once we are done.
                        viewTreeObserver.removeOnWindowFocusChangeListener(this)
                    }
                }
            })
    }
}

fun Activity.makeStatusBarTransparent() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.apply {
            //clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }
            statusBarColor = Color.TRANSPARENT
        }
    }
}

fun View.setMarginTop(marginTop: Int) {
    val menuLayoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
    menuLayoutParams.setMargins(0, marginTop, 0, 0)
    this.layoutParams = menuLayoutParams
}

fun View.invisible() {
    this.visibility = View.GONE
}

fun textDrawable(context: Context, size: Int, textColor: Int, bgColor: Int, text: String): Drawable? {
    if (text.isEmpty()) return AppCompatResources.getDrawable(context, R.drawable.ic_placeholder)

    val builder = StringBuilder()
    /*val reverse = text.reversed()
    val threshold = reverse.length - 1

    for (i in 0 until threshold) {
        val c = reverse[i]
        val after: Char = reverse[i + 1]
        if (after == ' ') builder.append(c.uppercaseChar())
        if (builder.length == 2) break
    }

    if (builder.length < 2) {
        builder.append(text[0].uppercaseChar())
    }
    val shortCapitalized: String = builder.reverse().toString()*/

    val threshold = text.length - 1
    val lastIndexOfSpace = text.lastIndexOf(' ')

    if (lastIndexOfSpace != -1 && lastIndexOfSpace < threshold) {
        builder.append(text[lastIndexOfSpace + 1].uppercase())
    }

    if (lastIndexOfSpace != 0) {
        val firstChar: Char = text[0]
        if (firstChar != ' ') builder.append(firstChar.uppercase())
    }
    val shortCapitalized: String = builder.toString()

    val shape = object : Shape() {
        override fun draw(canvas: Canvas, paint: Paint) {
            paint.isAntiAlias = true

            paint.color = ContextCompat.getColor(context, bgColor)
            canvas.drawCircle(width /2.0f, height /2.0f, width/2, paint)

            paint.color = ContextCompat.getColor(context, textColor)
            paint.textSize = width/2
            paint.textAlign = Paint.Align.LEFT

            /*val metric = paint.fontMetrics
            val textHeight = ceil(metric.descent - metric.ascent).toInt()
            val textY = textHeight - metric.descent*/
            //val textX = paint.measureText(display)
            val bounds = Rect()
            paint.getTextBounds(shortCapitalized, 0, shortCapitalized.length, bounds)
            val textX = bounds.width()
            val textY = bounds.height()
            canvas.drawText(shortCapitalized, width/2 - textX/2, height/2 + textY/2, paint)
            //
            //
            //canvas.drawCircle(canvas.width /2.0f, canvas.height /2.0f, radii, paint)
        }
    }

    val drawable =  ShapeDrawable(shape)
    val pxSize = AppUtils.dpToPx(size)
    drawable.intrinsicWidth = pxSize
    drawable.intrinsicHeight = pxSize

    return drawable
}
fun EditText.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 1)
}

fun MotionEvent.toLogString(): String {
    val actionName: String = when (action) {
        0 -> "ACTION_DOWN"
        1 -> "ACTION_UP"
        2 -> "ACTION_MOVE"
        3 -> "ACTION_CANCEL"
        else -> action.toString()
    }
    return "$actionName, ($x:$y) raw($x,$y)"
}
