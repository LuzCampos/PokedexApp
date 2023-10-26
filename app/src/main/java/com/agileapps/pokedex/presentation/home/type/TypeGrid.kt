package com.agileapps.pokedex.presentation.home.type

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.agileapps.pokedex.presentation.common.PokeballImage
import com.agileapps.pokedex.presentation.viewmodels.HomeViewModel

@Composable
fun TypeGrid(types: List<Type>, homeViewModel: HomeViewModel, navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .background(Color.White)
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(),
            //columns = GridCells.Fixed(2),
            columns = GridCells.Adaptive(144.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(types.size){
                    index ->
                val type = types[index]
                CardType(type = type, onClickCard = {
                    homeViewModel.getPokemonByType(type.type)
                    navController.navigate("list_pokedex_screen")
                })
            }
        }
    }
}


@Composable
fun CardType(type: Type,onClickCard: () -> Unit){
    Card(
        modifier = Modifier.height(74.dp).clickable { onClickCard() },
        shape = RoundedCornerShape(15.dp),
        contentColor = Color.White,
        elevation = 10.dp,
        backgroundColor = type.color
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().aspectRatio(1.98f)
        ) {
            PokeballImage(Modifier.align(Alignment.BottomEnd))
            Text(
                text = stringResource(id = type.label),
                modifier = Modifier
                    .padding(top = 20.dp, start = 12.dp)
                    .align(Alignment.CenterStart),
            )
        }
    }
}