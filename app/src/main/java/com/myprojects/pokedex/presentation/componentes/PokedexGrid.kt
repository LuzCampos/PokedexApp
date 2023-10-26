package com.myprojects.pokedex.presentation.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.agileapps.pokedex.R
import com.myprojects.pokedex.data.PokemonEntity
import com.myprojects.pokedex.presentation.common.TitleHeader
import com.myprojects.pokedex.presentation.entity.translator.PokemonTranslator

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
            header {
                TitleHeader(
                    text = stringResource(id = R.string.msg_pokedex_title),
                    Modifier.padding(bottom = 28.dp),
                    Color(0xff303943)
                )
            }

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                stringResource(id = R.string.msg_empty_pokedex),
                fontSize = 20.sp,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                textAlign = TextAlign.Center
            )
        }
    }
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}