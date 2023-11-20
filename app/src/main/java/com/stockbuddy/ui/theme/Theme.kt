package com.stockbuddy.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val darkColorPalette = darkColorScheme(
    primary = Color.Green,
    background = Color.Blue,
    onPrimary = Color.DarkGray,
    onBackground = Color.White,
)

val Typography = androidx.compose.material3.Typography()

@Composable
fun StockBuddyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) darkColorPalette else lightColorScheme(),
        typography = Typography,
        content = content
    )
}