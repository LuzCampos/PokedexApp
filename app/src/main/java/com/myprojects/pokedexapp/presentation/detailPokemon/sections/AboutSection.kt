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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.myprojects.pokedexapp.presentation.entity.PokemonUi


@Composable
fun AboutSection(pokemonui: PokemonUi) {
    Column(
        modifier = Modifier.padding(horizontal = 6.dp, vertical = 8.dp),
        //contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ){
        description(pokemonui.description)
        dimensionesPokemon(pokemonui)
        breeding(pokemonui)
    }
}
@Composable
fun breeding(pokemonui: PokemonUi) {
    Column(verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
        ) {
        Text(text = "Breeding", fontWeight = FontWeight.ExtraBold)
        Row() {
            Text(text = "Gender")
            Text(text = "${pokemonui.percent_female}")
            Text(text = "${pokemonui.percent_male}")
        }
    }
}

@Composable
fun dimensionesPokemon(pokemonui: PokemonUi){
    Card(
      //  elevation = 10.dp,
        modifier = Modifier.fillMaxWidth().shadow(ambientColor = Color.Red, elevation = 10.dp),
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
        modifier = Modifier.padding(vertical = 0.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
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


