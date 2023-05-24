package com.myprojects.pokedexapp.presentation.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.presentation.entity.translator.PokemonTranslator

@Composable
fun PokedexGrid(pokemonesLista: List<PokemonEntity>, modifier : Modifier,navController: NavController){

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
                Text(
                    text = "Pokedex",
                    fontFamily = FontFamily(Font(R.font.circularstdblack)),
                    color = Color(0xff303943),
                    modifier = Modifier.padding(bottom = 28.dp),
                    style = MaterialTheme.typography.h4.copy(
                        fontWeight =
                        FontWeight.ExtraBold
                    )
                )
            }

            items(pokemonesLista.size) { index ->
                val pokemon = pokemonesLista[index]
                val pokemonUi = pokemonTranslator.domainToUi(pokemon)
                PokemonCard(
                    pokemonUi = pokemonUi,
                    onClickCard = {
                        navController.navigate("detail/${pokemonUi.national_number}")
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
                "No pokemons yet.",
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