package com.myprojects.pokedex.presentation.componentes.floatingbutton

import com.agileapps.pokedex.R
import com.myprojects.pokedex.presentation.componentes.modalbottomsheet.BottomSheetType

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