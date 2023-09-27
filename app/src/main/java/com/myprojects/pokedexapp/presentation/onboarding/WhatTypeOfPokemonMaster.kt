package com.myprojects.pokedexapp.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.common.TitleHeader
import com.myprojects.pokedexapp.presentation.home.type.Type

@Composable
fun WhatTypeOfPokemonMaster(types: List<Type>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp, vertical = 30.dp),
           // .height(400.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
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
                    )
                    .fillMaxWidth()
                    .height(360.dp)
                    .background(Color(0xff494949))
            ) {
                Image(painter = painterResource(id = R.drawable.pokedexbackgroundscreen),
                    //contentScale
                    contentDescription = "" )
            }
       }
        
       item {
            Column(
                modifier = Modifier
                    .padding(vertical = 30.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth() ,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(R.drawable.pokedexiconavatar),
                        contentDescription = "Pokeball Shadow",
                        //colorFilter = ColorFilter.tint(Color(0xff805cfa)),
                        //alpha = 12f,
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                            .padding(end = 8.dp),
                    )
                    Text(
                        text = "Pokedex",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.circularstdbook)),
                            color = Color(0xff805cfa),
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
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 50.dp),
                    text = "Choose a type plan to unlock all the functionality",
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp ,
                    //color = Color(0xff303943),
                    color = Color.Black,
                    fontWeight = FontWeight.Black,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.circularstdbook)),
                )
            }
       }

       item {
           ContinueButtonW {
               
           }
       }

    }
}
@Composable
fun ContinueButtonW( onClick : () -> Unit) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            onClick = {
                onClick()
            },
            shape = RoundedCornerShape(20.dp) ,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                backgroundColor = Color(0xff6C79DB)
            )
        ) {
            Text(
                text = "Get Started",
                fontWeight = FontWeight.Black,
            )
        }
    
}

@Composable
fun HorizontalCardsType(types: List<Type>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(types) { type ->
            val cardShape = RoundedCornerShape(14.dp)
            Card(
                modifier = Modifier
                    .width(120.dp)
                    .height(146.dp)
                    .shadow(
                        elevation = 16.dp,
                        shape = cardShape,
                        spotColor = type.color
                    ),
                shape = cardShape,
                elevation = 16.dp,
                backgroundColor = type.color,
            ) {
                Column(
                    modifier = Modifier.padding(bottom = 16.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .size(60.dp)
                            .padding(bottom = 16.dp),
                        painter = painterResource(id = type.icon),
                        contentDescription = ""
                    )
                    Text(
                        text = stringResource(id = type.label),
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.circularstdbold)),
                    )
                }
            }
        }
    }
}