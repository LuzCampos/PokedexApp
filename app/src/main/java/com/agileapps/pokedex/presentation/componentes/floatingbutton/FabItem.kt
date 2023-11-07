package com.agileapps.pokedex.presentation.componentes.floatingbutton

import com.agileapps.pokedex.R
import com.agileapps.pokedex.presentation.componentes.modalbottomsheet.BottomSheetType

class FabItem(
    val icon: Int,
    val label:Int,
    val identifier:String
)

val items = listOf(
    FabItem(
        icon = R.drawable.pokeballicon,
        label = R.string.msg_fabItem_types,
        identifier = BottomSheetType.TYPE.name
    ),
    FabItem(
        icon = R.drawable.pokeballicon,
        label = R.string.msg_fabItem_gen,
        identifier = BottomSheetType.GENERATION.name
    )
)