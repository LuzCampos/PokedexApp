package com.myprojects.pokedex.presentation.componentes.modalbottomsheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.myprojects.pokedex.presentation.componentes.modalbottomsheet.generation.Generation
import com.myprojects.pokedex.presentation.viewmodels.HomeViewModel
import com.myprojects.pokedex.presentation.common.SearchComponent
import com.myprojects.pokedex.presentation.componentes.modalbottomsheet.generation.AllGen
import com.myprojects.pokedex.presentation.home.type.Type

@Composable
fun SheetLayout(
    bottomSheetType: BottomSheetType,
    searchText: MutableState<String>, homeViewModel: HomeViewModel,
    generation: List<Generation>,
    type: List<Type>,
    modifier:Modifier
){
    when(bottomSheetType){
        BottomSheetType.TYPE1 -> SearchComponent(searchText,homeViewModel, modifier)
        BottomSheetType.TYPE2 -> AllType(type,homeViewModel)
        BottomSheetType.TYPE3 -> AllGen(generation,homeViewModel)
    }

}