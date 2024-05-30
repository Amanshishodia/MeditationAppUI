package com.example.meditationappui.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography

import androidx.compose.runtime.Composable


@Composable
fun MeditationUIYouTubeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    MaterialTheme(
       // typography = Typography,
        shapes = Shapes,
        content = content
    )
}

