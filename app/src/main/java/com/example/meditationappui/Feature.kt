package com.example.meditationappui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val ligitColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)
