package com.myprojects.pokedexapp.presentation.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.common.TitleHeader

@Composable
fun CaptureThemAll() {
    // Lista de elementos
    val items = listOf("Respuesta 1", "Respuesta 2", "Respuesta 3")

    // Índice del elemento seleccionado por defecto (puedes cambiarlo)
    var defaultSelectedItemIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.height(400.dp),
        verticalArrangement = Arrangement.Top
    ) {
        TitleHeader(text = "Captúralos", modifier = Modifier.align(Alignment.CenterHorizontally),Color(0xff303943))
        Column(
            modifier = Modifier.padding(top = 36.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {
            LinearProgressIndicator(
                modifier = Modifier
                    .shadow(shape = RoundedCornerShape(24.dp), elevation = 0.dp)
                    .fillMaxWidth()
                    .height(4.dp),
                progress = 0.3f,
                color = Color(0xff6C79DB),
                backgroundColor = Color.LightGray
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = 0.dp,
                backgroundColor = Color(0xfff4eff3)
            ) {
                Text(
                    text = "Pick the correct answer",
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.circularstdbook)),
                )
            }
            Text(
                text = "Select one.",
                modifier = Modifier.align(Alignment.Start),
                fontFamily = FontFamily(Font(R.font.circularstdbold)),
                color = Color.Gray,
                fontSize = 10.sp
            )
            items.forEachIndexed { index, item ->
                val isSelected = index == defaultSelectedItemIndex
                val backgroundColor = if (isSelected) Color(0xff6C79DB) else Color.Transparent
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    border = BorderStroke(2.dp, backgroundColor),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = item,
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.circularstdbook)),
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.pokeballicon),
                            tint = backgroundColor,
                            contentDescription = "")
                    }
                }
            }
        }
    }
}