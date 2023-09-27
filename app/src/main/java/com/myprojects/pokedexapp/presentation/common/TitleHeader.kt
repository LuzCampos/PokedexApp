package com.myprojects.pokedexapp.presentation.common

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.myprojects.pokedexapp.R

@Composable
fun TitleHeader(text:String, modifier:Modifier) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = FontFamily(Font(R.font.circularstdblack)),
            color = Color(0xff303943),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 26.sp,
            textAlign = TextAlign.Start,
            lineHeight = 42.sp
        ),
        modifier = modifier
    )
}