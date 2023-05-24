package com.myprojects.pokedexapp.presentation.detailPokemon.sections
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.entity.PokemonUi
import java.util.*


@Composable
fun AboutSection(pokemonui: PokemonUi) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 6.dp, vertical = 8.dp),
        //contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ){
        description(pokemonui.description)
        dimensionesPokemon(pokemonui)
        breeding(pokemonui,
            Modifier
                .fillMaxWidth()
                )
    }
}
@Composable
fun breeding(pokemonui: PokemonUi, modifier: Modifier) {
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = modifier
        ) {
        Text(modifier= Modifier.padding(vertical = 6.dp),text = "Breeding", fontWeight = FontWeight.ExtraBold)
        breedingRow(breedingText = "Gender", pokemonui = pokemonui)
        breedingRow(breedingText = "Egg cycle", pokemonui = pokemonui)
    }
}

@Composable
fun breedingRow(breedingText:String, pokemonui: PokemonUi){
    Row( modifier = Modifier.padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        breedingTitle(texto = breedingText)
        if(breedingText == "Gender"){
            genderTextValue(gender = "${pokemonui.percent_male}", icono = R.drawable.gendermale)
            genderTextValue(gender = "${pokemonui.percent_female}", icono = R.drawable.genderfemale)
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
fun genderTextValue(gender:String, icono:Int) {
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
fun breedingTitle(texto:String){
    Text(
        text = texto,
        color = Color(0xFF8C9092),
        modifier = Modifier.padding(end = 20.dp))
}

@Composable
fun dimensionesPokemon(pokemonui: PokemonUi){
    Card(
      //  elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth().padding(vertical = 10.dp)
            .shadow(ambientColor = Color.White, elevation = 8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp)) {
            dimension(title = "Height", dimension = pokemonui.getHeightFormatted())
            dimension(title = "Weight", dimension = pokemonui.getLibsFormatted())
        }
    }
}

@Composable
fun dimension(title:String, dimension:String){
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
fun description(desc: String) {
   Text(
       text = "$desc",
       color = Color(0xff303943)
   )
}


