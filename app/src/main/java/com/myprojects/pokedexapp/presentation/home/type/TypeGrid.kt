package com.myprojects.pokedexapp.presentation.home.type

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.myprojects.pokedexapp.presentation.componentes.PokeballImage
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel

@Composable
fun TypeGrid(types: List<Type>, homeViewModel: HomeViewModel){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .background(Color.White)
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(types.size){
                    index ->
                val type = types[index]
                CardType(type = type, homeViewModel = homeViewModel)
            }
        }
    }
}


@Composable
fun CardType(type: Type,homeViewModel: HomeViewModel){
    Card(
        modifier = Modifier.height(60.dp),
        shape = RoundedCornerShape(15.dp),
        contentColor = Color.White,
        elevation = 10.dp,
        backgroundColor = type.color
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            PokeballImage(Modifier.align(Alignment.BottomEnd))
            Text(text = type.label, modifier = Modifier
                .padding(top = 20.dp, start = 12.dp)
                .align(Alignment.TopStart),)
        }
    }
}