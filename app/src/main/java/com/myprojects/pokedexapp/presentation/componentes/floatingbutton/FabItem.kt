package com.myprojects.pokedexapp.presentation.componentes.floatingbutton

import com.myprojects.pokedexapp.R
import com.myprojects.pokedexapp.presentation.componentes.modalbottomsheet.BottomSheetType

class FabItem(
    val icon: Int,
    val label:String,
    val identifier:String
)

val items = listOf(
    FabItem(
        icon = R.drawable.searchicon,
        label = "Search Pokemon",
        identifier = BottomSheetType.TYPE1.name
    ),
    FabItem(
        icon = R.drawable.pokeballicon,
        label = "All Type",
        identifier = BottomSheetType.TYPE2.name
    ),
    FabItem(
        icon = R.drawable.pokeballicon,
        label = "All Gen",
        identifier = BottomSheetType.TYPE3.name
    )
)