package com.myprojects.pokedexapp.presentation.onboarding

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.pokedexapp.R

data class CardTimeItem(val selectedTimeItem : String)

val itemsTime = listOf(
    CardTimeItem("7 horas o menos"),
    CardTimeItem("7-9 horas"),
    CardTimeItem("9-12 horas"),
    CardTimeItem("12 horas o más")
)

@Composable
fun SleepTimeScreen() {

    var defaultSelectedItemIndex by remember { mutableStateOf(-1) }

    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xff6160ec))
    ) {
        // Fondo
        Box(
            modifier = Modifier.fillMaxWidth().aspectRatio(1.5f),
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_winter),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        )
        {
            Text(
                text = "¿Cuánto duermes\nhábitualmente por la noche?",
                modifier = Modifier.align(Alignment.Start).padding(bottom = 26.dp),
                color = Color.White,
                fontSize = 22.sp,
                lineHeight = 26.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.circularstdblack))
            )
            itemsTime.forEachIndexed { index, cardTimeItem ->
                val isSelected = index == defaultSelectedItemIndex
                val backgroundColor = if (isSelected) Color(0xff301F84) else Color(0xffFFFFFF)
                val textItem = if (isSelected) Color.White else Color(0xff301F84)

                ItemTextTime(
                    cardTimeItem = cardTimeItem,
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = textItem,
                    backgroundColor = backgroundColor
                ) { defaultSelectedItemIndex = index }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun ItemTextTime(cardTimeItem : CardTimeItem, modifier: Modifier, color: Color, backgroundColor : Color, onClick : () -> Unit){
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(6.dp)).shadow(6.dp)
            .height(IntrinsicSize.Min)
            .background(backgroundColor)
            .clickable { onClick() },
    ) {
        Text(
            modifier = Modifier.align(Alignment.BottomStart).padding(top = 46.dp, start = 16.dp, bottom = 14.dp),
            text = cardTimeItem.selectedTimeItem,
            fontWeight = FontWeight.W800,
            letterSpacing = 0.sp,
            fontSize = 15.sp,
            color = color
        )
    }
}