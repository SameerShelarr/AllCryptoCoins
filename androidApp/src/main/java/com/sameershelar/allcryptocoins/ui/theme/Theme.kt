package com.sameershelar.allcryptocoins.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = CryptoOrangeLighter,
    primaryVariant = CryptoOrange,
    secondary = CryptoGreen
)

private val LightColorPalette = lightColors(
    primary = CryptoOrangeLight,
    primaryVariant = CryptoOrange,
    secondary = CryptoGreen
)

@Composable
fun AllCryptoCoinsTheme(
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