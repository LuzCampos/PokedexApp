package com.myprojects.pokedexapp.presentation.detailPokemon.sections
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.entity.PokemonUi
import java.util.*


@Composable
fun AboutSection(pokemonui: PokemonUi) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 6.dp, vertical = 8.dp),
        //contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ){
        item { Description(pokemonui.description) }
        item { DimensionesPokemon(pokemonui) }
        item { Breeding(pokemonui,
            Modifier
                .fillMaxWidth()
        )}
    }
}
@Composable
fun Breeding(pokemonui: PokemonUi, modifier: Modifier) {
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = modifier
        ) {
        Text(modifier= Modifier.padding(vertical = 6.dp),text = stringResource(id = R.string.msg_about_breeding), fontWeight = FontWeight.ExtraBold)
        BreedingRow(breedingText = stringResource(id = R.string.msg_about_gender), pokemonui = pokemonui)
        BreedingRow(breedingText = stringResource(id = R.string.msg_about_eggcycle), pokemonui = pokemonui)
    }
}

@Composable
fun BreedingRow(breedingText:String, pokemonui: PokemonUi){
    Row( modifier = Modifier.padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        BreedingTitle(texto = breedingText)
        if(breedingText == stringResource(id = R.string.msg_about_gender)){
            GenderTextValue(gender = "${pokemonui.percent_male}", icono = R.drawable.gendermale)
            GenderTextValue(gender = "${pokemonui.percent_female}", icono = R.drawable.genderfemale)
        } else {
            Text(text = pokemonui.primary_type.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            },)
        }
    }
}

@Composable
fun GenderTextValue(gender:String, icono:Int) {
    Row(modifier = Modifier.padding(end = 14.dp) ,verticalAlignment = Alignment.CenterVertically) {
        Image(
            ImageBitmap.imageResource(icono),
            contentDescription = "fav",
            modifier = Modifier.size(14.dp)
        )
        Text( modifier = Modifier.padding(start = 2.dp) ,text = "$gender%")
    }
}

@Composable
fun BreedingTitle(texto:String){
    Text(
        text = texto,
        color = Color(0xFF8C9092),
        modifier = Modifier.padding(end = 20.dp))
}

@Composable
fun DimensionesPokemon(pokemonui: PokemonUi){
    Card(
      //  elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .shadow(ambientColor = Color.White, elevation = 8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp)) {
            Dimension(title = stringResource(id = R.string.msg_about_height), dimension = pokemonui.getHeightFormatted())
            Dimension(title = stringResource(id = R.string.msg_about_weight), dimension = pokemonui.getLibsFormatted())
        }
    }
}

@Composable
fun Dimension(title:String, dimension:String){
    Column(
        modifier = Modifier.padding(vertical = 4.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = title, color = Color(0xffACB0B4))
        Text(text = dimension)
    }
}

@Composable
fun Description(desc: String) {
   Text(
       text = desc,
       color = Color(0xff303943)
   )
}


