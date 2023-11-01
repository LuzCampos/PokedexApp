package com.agileapps.pokedex.presentation.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.agileapps.pokedex.presentation.common.PokeballImage
import com.agileapps.pokedex.presentation.common.PokemonImage
import com.agileapps.pokedex.presentation.entity.PokemonUi
import java.util.*

@Composable
fun PokemonCard(pokemonUi: PokemonUi, onClickCard: () -> Unit) {
    Card(
        shape = RoundedCornerShape(24.dp),
        contentColor = MaterialTheme.colors.primaryVariant,
        elevation = 10.dp,
        backgroundColor = Color(pokemonUi.backgroundColorValue)
    )
    {
        Box(modifier = Modifier
            .clickable { onClickCard() }
            .fillMaxWidth()
            .aspectRatio(1.36f)
        ) {
            PokeballImage(Modifier.align(Alignment.BottomEnd))
            PokemonImage(pokemonUi.pokemonDrawableResourceId, Modifier.align(Alignment.BottomEnd).padding(end = 10.dp, bottom = 10.dp))
            Text(
                text = pokemonUi.getNumberFormatted(),
                color = MaterialTheme.colors.secondaryVariant,
                modifier = Modifier
                    .padding(top = 8.dp, end = 16.dp)
                    .align(Alignment.TopEnd),
                fontWeight = FontWeight.Bold
            )
            Column(
                modifier = Modifier
                    //   .align(Alignment.Cen)
                    .padding(start = 18.dp, top = 24.dp)
            ) {
                Text(
                    pokemonUi.english_name,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.padding(4.dp))
                PowerChip(text = pokemonUi.primary_type)
                Spacer(modifier = Modifier.padding(2.dp))
                if (pokemonUi.secondary_type.isNotEmpty()) {
                    PowerChip(text = pokemonUi.secondary_type)
                }
            }
        }
    }
}

@Composable
fun PowerChip(text: String, modifier: Modifier = Modifier) {
    Text(
        text.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        },
        color =MaterialTheme.colors.primaryVariant,
        style = MaterialTheme.typography.overline,
        modifier = modifier
            .background(
                color = MaterialTheme.colors.primaryVariant.copy(alpha = .15f), shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 12.dp, vertical = 4.dp),
    )
}




