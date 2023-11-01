package com.agileapps.pokedex.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Color.Black,
    secondary = Color(0xff303943),
    onBackground = Color.Transparent,
    onPrimary = Color.White,
    onSecondary = Color(0xFF8C9092),
    secondaryVariant = Color.Black.copy(.5f),
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Color.White,
    secondary = Color(0xffFFFFFF),
    onBackground = Color(0xffFFFFFF),
    onPrimary =  Color(0xff303943),
    onSecondary = Color(0xff303943),
    secondaryVariant = Color.Black.copy(.2f),

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun PokedexAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit) {


    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        //typography = Typography,
        typography = CustomTypography,
        shapes = Shapes,
        content = content
    )
}