package com.agileapps.pokedex.presentation.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.agileapps.pokedex.data.PokemonEntity
import com.agileapps.pokedex.presentation.entity.translator.PokemonTranslator

@Composable
fun PokedexGrid(pokemonesLista: List<PokemonEntity>, modifier : Modifier, navController: NavController){

    val pokemonTranslator = remember {
        PokemonTranslator()
    }

    if (pokemonesLista.isNotEmpty()) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(144.dp),
            modifier = modifier,
            contentPadding = PaddingValues(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ){
            items(pokemonesLista.size) { index ->
                val pokemon = pokemonesLista[index]
                val pokemonUi = pokemonTranslator.domainToUi(pokemon)
                PokemonCard(
                    pokemonUi = pokemonUi,
                    onClickCard = {
                        navController.navigate("detail?national_number=${pokemonUi.national_number}&evochain_0=${pokemonUi.evochain_0}&evochain_2=${pokemonUi.evochain_2}&evochain_4=${pokemonUi.evochain_4}")
                    }
                )
            }

        }

    } else {
       Box{}
    }
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}