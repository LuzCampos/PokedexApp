package com.agileapps.pokedex.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agileapps.pokedex.R

@Composable
fun WelcomeScreen(state: WelcomeScreenState, navigateTo: () -> Unit) {

    val title = state.title
    val description = state.description
    val text_button = state.text_button

    LazyColumn(
        modifier = Modifier.fillMaxSize().fillMaxHeight().padding(horizontal = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        item {
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 24.dp,
                            bottomStart = 24.dp,
                            topEnd = 24.dp,
                            bottomEnd = 100.dp
                        )
                    ).fillMaxWidth().height(
                        390.dp
                    //IntrinsicSize.Min
                    ).background(Color(0xff494949))
            ) { Image(
                painter = painterResource(id = R.drawable.pokedexbackgroundscreen),
                contentDescription = "", contentScale = ContentScale.Fit) }
        }
        item {
            Column(
                modifier = Modifier.padding(vertical = 20.dp).fillMaxWidth().height(IntrinsicSize.Min),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(R.drawable.pokeballbackground),
                        contentDescription = "Pokeball Shadow",
                        colorFilter = ColorFilter.tint(Color(0xff6C79DB),),
                        modifier = Modifier.size(width = 50.dp, height = 50.dp).padding(end = 8.dp),
                    )
                    Text(
                        text = title,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.circularstdbook)),
                            color = Color(0xff6C79DB),
                            //color = Color(0xff805cfa),
                            fontSize = 26.sp,
                            fontWeight = FontWeight.W900,
                            textAlign = TextAlign.Center,
                            lineHeight = 50.sp
                        ),
                        modifier = Modifier
                    )
                }
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 50.dp),
                    text = description,
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp,
                    color = Color(0xff242c33),
                    fontWeight = FontWeight.Black,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.circularstdbook)),
                )
            }
        }
        item { ContinueButtonW(text_button) { navigateTo() } }
    }
}

@Composable
fun ContinueButtonW(text_button: String,onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth().height(66.dp).padding(bottom = 2.dp),
        onClick = { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(contentColor = Color.Black, backgroundColor = Color(0xff6C79DB))
    ) { Text(text = text_button, fontWeight = FontWeight.Black, color = Color.White) }
}

