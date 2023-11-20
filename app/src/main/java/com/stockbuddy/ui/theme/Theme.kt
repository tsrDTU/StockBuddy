package com.stockbuddy.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val darkColorPalette = darkColorScheme(
    primary = Color.Green,
    background = Color.Blue,
    onPrimary = Color.DarkGray,
    onBackground = Color.White,
)

@Composable
fun StockBuddyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = darkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}