package com.myprojects.pokedexapp.presentation.detailPokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.myprojects.pokedexapp.data.PokemonEntity
import com.myprojects.pokedexapp.presentation.detailPokemon.sections.AboutSection
import com.myprojects.pokedexapp.presentation.detailPokemon.sections.BaseStatsSection
import com.myprojects.pokedexapp.presentation.detailPokemon.sections.EvolutionSection
import com.myprojects.pokedexapp.presentation.detailPokemon.sections.MovesSection
import com.myprojects.pokedexapp.presentation.entity.PokemonUi
import com.myprojects.pokedexapp.presentation.entity.translator.PokemonTranslator
import com.myprojects.pokedexapp.presentation.viewmodels.HomeViewModel
import java.util.*

@Composable
fun PokemonDetail(
    national_number: String?,
    homeViewModel: HomeViewModel,
    navController: NavController
) {
    val pokemonTranslator = remember {
        PokemonTranslator()
    }
    homeViewModel.getPokemonById(national_number!!.toInt())
    val selectedPokemon = homeViewModel.pokemon.observeAsState().value
    if (selectedPokemon != null) contenido(selectedPokemon, pokemonTranslator = pokemonTranslator)
}

@Composable
fun contenido(pokemon : PokemonEntity, pokemonTranslator: PokemonTranslator){
    val pokemonUi = pokemonTranslator.domainToUi(pokemon)
    Surface(color = Color(pokemonUi.backgroundColorValue)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            HeaderRight(pokemonUi)
            HeaderLeft(pokemonUi)
            SectionsContent(pokemonUi)
            PokemonImage(pokemonUi)
        }
    }
}

@Composable
fun titulo(name : String){
    Text(text = "$name")
}

private enum class Sections(val title: String) {
    About("About"),
    BaseStats("Base stats"),
    Evolution("Evolution"),
    Moves("Moves")
}

@Composable
private fun BoxScope.HeaderRight(pokemonui: PokemonUi) {
    Column (
        modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(top = 52.dp, end = 32.dp).height(50.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier.align(Alignment.End),
            text = pokemonui.getNumberFormatted(),
            style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier.align(Alignment.End),
            text = pokemonui.classification ?: "",
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.White
            )
        )
    }
}

@Composable
private fun BoxScope.HeaderLeft(pokemonui: PokemonUi) {
    Column (
        modifier = Modifier
            .align(Alignment.TopStart)
            .padding(top = 42.dp, start = 32.dp).height(68.dp),

    ){
        Text(
            modifier = Modifier.align(Alignment.Start),
            text = pokemonui.english_name,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Row() {
           PowerChip(text = pokemonui.primary_type ?: "",)
           Spacer(modifier = Modifier.width(6.dp))
            if (pokemonui.secondary_type.isNotEmpty()){
                PowerChip(text = pokemonui.secondary_type ?: "")
            }
        }
    }
}

@Composable
private fun PowerChip(text: String) {
    Text(
        text.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        },
        fontSize = 10.sp,
        color = Color.White,
        style = MaterialTheme.typography.overline,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .background(
                color = Color.White.copy(alpha = .26f), shape = RoundedCornerShape(38.dp)
            )
            .padding(horizontal = 14.dp, vertical = 4.dp),
    )
}


@Composable
private fun BoxScope.SectionsContent(pokemonui: PokemonUi) {
    Surface(
        modifier = Modifier
            .padding(top = 320.dp)
            .clip(shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .align(Alignment.TopCenter)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            val sectionTitles = Sections.values().map { it.title }
            var section by remember { mutableStateOf(Sections.BaseStats) }
            TabRow(selectedTabIndex = section.ordinal,
                //divider = {},
                indicator = {
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(it[section.ordinal])
                            .clip(shape = RoundedCornerShape(4.dp))
                            .padding(horizontal = 20.dp),
                        height = 2.dp,
                        color = Color(0xff6C79DB),
                    )
                }, 
                backgroundColor = Color.White) {
                sectionTitles.forEachIndexed { index, text ->
                    Tab(
                        selected = section.ordinal == index,
                        onClick = { section = Sections.values()[index] },
                        text = { Text(text) },
                        selectedContentColor = Color(0xff303943),
                        unselectedContentColor = Color.LightGray
                    )
                }
            }
            Box(modifier = Modifier.padding(24.dp)) {
                when (section) {
                    Sections.About -> AboutSection(pokemonui)
                    Sections.BaseStats -> BaseStatsSection(pokemonui)
                    Sections.Evolution -> EvolutionSection(pokemonui)
                    Sections.Moves -> MovesSection(pokemonui)
                }
            }
        }
    }
}

@Composable
private fun BoxScope.PokemonImage(pokemon: PokemonUi) {
    pokemon.pokemonDrawableResourceId.let { image ->
            Image(
                modifier = Modifier
                    .size(358.dp)
                    .align(Alignment.TopCenter)
                    .padding(top = 158.dp),
                painter = painterResource(id = image),
                alpha = 1.0f,
                contentDescription = "pokemonimagedetail" )
        }
}
