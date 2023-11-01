package com.agileapps.pokedex.presentation.componentes.modalbottomsheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.agileapps.pokedex.presentation.componentes.modalbottomsheet.generation.Generation
import com.agileapps.pokedex.presentation.viewmodels.HomeViewModel
import com.agileapps.pokedex.presentation.common.SearchComponent
import com.agileapps.pokedex.presentation.componentes.modalbottomsheet.generation.GridGeneration
import com.agileapps.pokedex.presentation.home.type.Type

@Composable
fun SheetLayout(
    bottomSheetType: BottomSheetType,
    searchText: MutableState<String>, homeViewModel: HomeViewModel,
    generation: List<Generation>,
    type: List<Type>,
    modifier:Modifier,
    closeSheet: () -> Unit
){
    when(bottomSheetType){
        BottomSheetType.SEARCH -> SearchComponent(searchText,homeViewModel, modifier)
        BottomSheetType.TYPE -> GridType(type,homeViewModel,closeSheet)
        BottomSheetType.GENERATION -> GridGeneration(generation,homeViewModel,closeSheet)
    }

}