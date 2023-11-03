package com.agileapps.pokedex.presentation.componentes.floatingbutton

import com.agileapps.pokedex.R
import com.agileapps.pokedex.presentation.componentes.modalbottomsheet.BottomSheetType

class FabItem(
    val icon: Int,
    val label:String,
    val identifier:String
)

val items = listOf(
    FabItem(
        icon = R.drawable.pokeballicon,
        label = "All Type",
        identifier = BottomSheetType.TYPE.name
    ),
    FabItem(
        icon = R.drawable.pokeballicon,
        label = "All Gen",
        identifier = BottomSheetType.GENERATION.name
    )
)