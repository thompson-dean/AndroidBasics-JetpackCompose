package com.example.project30daysofquotes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White

private val DarkColorPalette = darkColors(
    background = Navy1,
    surface = Navy1,
    onSurface = White,
    primary = White,
    onPrimary = Navy4,
    secondary = Navy2
)

private val LightColorPalette = lightColors(
    background = White,
    surface = WhiteGrey,
    onSurface = Navy4,
    primary = Black,
    onPrimary = Navy3,
    secondary = Navy2

)

@Composable
fun Project30DaysOfQuotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}