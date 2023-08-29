package com.myprojects.pokedexapp.presentation.home.news
import com.myprojects.pokedexapp.R

class News (
    val title:String,
    val date:String,
    val image:Int
)

val news = listOf(
    News(title = "Pokémon Rumble Rush Arrives Soon", "15 May 2019", R.drawable.rumblerushnew),
    News(title = "Detective Pikachu Sleuths into Pokémon GO", "15 May 2019", R.drawable.detectivepikachunew)
)