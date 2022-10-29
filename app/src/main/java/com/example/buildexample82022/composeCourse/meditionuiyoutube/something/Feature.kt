package com.example.buildexample82022.composeCourse.meditionuiyoutube.something

import android.graphics.Color
import androidx.annotation.DrawableRes

data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)
