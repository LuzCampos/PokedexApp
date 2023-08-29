package com.myprojects.pokedexapp.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.myprojects.pokedexapp.R

@Composable
fun BoxScope.PokeBallBackground(){
    Box(
        modifier = Modifier
            .align(Alignment.TopEnd)
            .offset(x = 90.dp, y = (-60).dp),
    ) {
        Image(
            modifier = Modifier.size(274.dp).align(Alignment.TopEnd),
            painter = painterResource(R.drawable.pokeballbackground),
            contentDescription = "Pokeball Shadow",
            colorFilter = ColorFilter.tint(color = Color(0xff303943).copy(0.06f))
        )
    }
}