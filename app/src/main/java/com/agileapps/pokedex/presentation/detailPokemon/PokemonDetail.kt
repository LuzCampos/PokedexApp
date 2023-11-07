package com.agileapps.pokedex.presentation.detailPokemon

import androidx.annotation.StringRes
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.agileapps.pokedex.R
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.agileapps.pokedex.data.PokemonEntity
import com.agileapps.pokedex.presentation.detailPokemon.sections.AboutSection
import com.agileapps.pokedex.presentation.detailPokemon.sections.BaseStatsSection
import com.agileapps.pokedex.presentation.detailPokemon.sections.EvolutionSection
import com.agileapps.pokedex.presentation.detailPokemon.sections.MovesSection
import com.agileapps.pokedex.presentation.entity.PokemonUi
import com.agileapps.pokedex.presentation.entity.translator.PokemonTranslator
import com.agileapps.pokedex.presentation.viewmodels.DetailViewModel
import com.agileapps.pokedex.ui.theme.PokedexAppTheme
import java.util.*

@Composable
fun PokemonDetail(
    national_number: String?,
    evochain_0: String?,
    evochain_2: String?,
    evochain_4: String?,
    detailViewModel: DetailViewModel = hiltViewModel(),
    navController: NavController,
    isDarkTheme : Boolean,
    onClick : () -> Unit
) {
    val pokemonTranslator = remember {
        PokemonTranslator()
    }
    detailViewModel.getPokemonById(national_number!!.toInt())
    detailViewModel.getPokemonEvo0ByName(evochain_0!!.toString())
    detailViewModel.getPokemonEvo2ByName(evochain_2!!.toString())
    detailViewModel.getPokemonEvo4ByName(evochain_4!!.toString())
    val selectedPokemon = detailViewModel.pokemon.observeAsState().value
    val addEvo0Pokemon = detailViewModel.pokemonEvo0.observeAsState().value
    val addEvo2Pokemon = detailViewModel.pokemonEvo2.observeAsState().value
    val addEvo4Pokemon = detailViewModel.pokemonEvo4.observeAsState().value
    if (selectedPokemon != null) Contenido(selectedPokemon, addEvo0Pokemon, addEvo2Pokemon, addEvo4Pokemon, pokemonTranslator = pokemonTranslator, navController, isDarkTheme, onClick)
    
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Contenido(pokemon : PokemonEntity, pokemonEvo0: PokemonEntity?, pokemonEvo2: PokemonEntity?, pokemonEvo4 : PokemonEntity?, pokemonTranslator: PokemonTranslator, navController: NavController,isDarkTheme: Boolean, onClick : () -> Unit ){

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val pokemonUi = pokemonTranslator.domainToUi(pokemon)
    val pokemonUiEvo0 = pokemonEvo0?.let { pokemonTranslator.domainToUi(it) }
    val pokemonUiEvo2 = pokemonEvo2?.let { pokemonTranslator.domainToUi(it) }
    val pokemonUiEvo4 = pokemonEvo4?.let { pokemonTranslator.domainToUi(it) }

    var isAnimationRunning by remember { mutableStateOf(true) }

    DisposableEffect(Unit) {
        onDispose {
            // Cuando la pantalla se destruye, deten la animación
            isAnimationRunning = false
        }
    }

    fun resumeAnimation() {
        isAnimationRunning = true
    }

    val fraction = 0.63f
    val screenHeightDp: Dp = with(LocalDensity.current) {
        LocalConfiguration.current.screenHeightDp.dp
    }

    val sheetPeekHeight: Dp = screenHeightDp * fraction
    val icon = if(isDarkTheme) {R.drawable.iconday} else {R.drawable.iconnight}

    PokedexAppTheme(
        darkTheme = isDarkTheme
    ) {
        BottomSheetScaffold(
            scaffoldState = bottomSheetScaffoldState,
            sheetContent = {
                SectionContent(pokemonUi, pokemonUiEvo0, pokemonUiEvo2, pokemonUiEvo4)
            },
            sheetPeekHeight = sheetPeekHeight, // Set the initial peek height
            sheetBackgroundColor = Color.Transparent,
            sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            sheetElevation = 0.dp,
        ) {
            Surface(color = Color(pokemonUi.backgroundColorValue)) {
                Box(modifier = Modifier.fillMaxSize()) {
                    TopAppBar(
                        backgroundColor = Color.Transparent,
                        elevation = 0.dp,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(vertical = 30.dp, horizontal = 20.dp),
                        title = {
                            //  Button(onClick = {  !darkTheme }) { Text(text = text) }
                        },
                        navigationIcon = {
                            IconButton(modifier = Modifier.size(30.dp),
                                onClick = { navController.popBackStack() }
                            ) {
                                Icon(
                                    Icons.Filled.ArrowBack,
                                    tint = MaterialTheme.colors.primaryVariant,
                                    contentDescription = ""
                                )
                            }
                        },
                        actions = {
                            IconButton(modifier = Modifier.size(26.dp),onClick = { onClick() }) {
                                Icon(
                                    painter = painterResource(id = icon),
                                    tint = MaterialTheme.colors.primaryVariant,
                                    contentDescription = "iconNightMode"
                                )
                            }
                        }
                    )
                    HeaderRight(pokemonUi)
                    HeaderLeft(pokemonUi)
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.46f),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        PokeballSpinning(color = MaterialTheme.colors.onBackground)
                    }
                    SectionsContent()
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.46f),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        PokemonImage(pokemon = pokemonUi)
                    }
                }
            }
        }
    }

    DisposableEffect(isAnimationRunning) {
        if (isAnimationRunning) { resumeAnimation() }
        onDispose { }
    }
}

private enum class Sections(@StringRes val title: Int) {
    About(R.string.detail_pokemon_about),
    BaseStats(R.string.detail_pokemon_basestats),
    Evolution(R.string.detail_pokemon_evolution),
    Moves(R.string.detail_pokemon_moves)
}

@Composable
private fun BoxScope.HeaderRight(pokemonui: PokemonUi) {
    Column (
        modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(top = 92.dp, end = 32.dp)
            .height(50.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier.align(Alignment.End),
            text = pokemonui.getNumberFormatted(),
            style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                color = MaterialTheme.colors.primaryVariant
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier.align(Alignment.End),
            text = pokemonui.classification,
            style = TextStyle(
                fontSize = 12.sp,
                color = MaterialTheme.colors.primaryVariant
            )
        )
    }
}

@Composable
private fun BoxScope.HeaderLeft(pokemonui: PokemonUi) {
    Column (
        modifier = Modifier
            .align(Alignment.TopStart)
            .padding(top = 82.dp, start = 32.dp)
            .height(68.dp),

        ){
        Text(
            modifier = Modifier.align(Alignment.Start),
            text = pokemonui.english_name,
            fontFamily = FontFamily(Font(R.font.circularstdblack)),
            style = TextStyle(
                fontSize = 30.sp,
                color = MaterialTheme.colors.primaryVariant
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Row {
            PowerChip(text = pokemonui.primary_type)
            Spacer(modifier = Modifier.width(6.dp))
            if (pokemonui.secondary_type.isNotEmpty()) PowerChip(text = pokemonui.secondary_type)
        }
    }
}

@Composable
private fun PowerChip(text: String) {
    Text(
        text.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        },
        fontSize = 10.sp,
        color = MaterialTheme.colors.primaryVariant,
        style = MaterialTheme.typography.overline,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.primaryVariant.copy(alpha = .26f),
                shape = RoundedCornerShape(38.dp)
            )
            .padding(horizontal = 14.dp, vertical = 4.dp),
    )
}

@Composable
private fun SectionContent(pokemonui: PokemonUi, pokemonuievo0: PokemonUi? = null, pokemonuievo2: PokemonUi? = null, pokemonuievo4: PokemonUi? = null){
    Surface(
        modifier = Modifier
            .background(MaterialTheme.colors.onBackground)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(22.dp))
            val sectionTitles = Sections.values().map { it.title }
            var section by remember { mutableStateOf(Sections.BaseStats) }
            TabRow(selectedTabIndex = section.ordinal,
                divider = {
                    Divider(modifier = Modifier.padding(horizontal = 30.dp), color = MaterialTheme.colors.onBackground, thickness = 1.dp)
                },
                indicator = {
                    TabRowDefaults.Indicator(
                        modifier = Modifier
                            .tabIndicatorOffset(it[section.ordinal])
                            .clip(shape = RoundedCornerShape(4.dp))
                            .padding(horizontal = 20.dp),
                        height = 2.dp,
                        color = Color(0xff6C79DB),
                    )
                },
                backgroundColor = MaterialTheme.colors.onBackground
            ) {
                sectionTitles.forEachIndexed { index, text ->
                    Tab(
                        selected = section.ordinal == index,
                        onClick = { section = Sections.values()[index] },
                        text = { Text(stringResource(id = text), fontSize = 12.sp) },
                        selectedContentColor = Color(0xff303943),
                        unselectedContentColor = Color.LightGray
                    )
                }
            }
            Box(modifier = Modifier.padding(24.dp), contentAlignment = Alignment.Center) {
                when (section) {
                    Sections.About -> AboutSection(pokemonui)
                    Sections.BaseStats -> BaseStatsSection(pokemonui)
                    Sections.Evolution -> EvolutionSection(pokemonuievo0, pokemonuievo2, pokemonuievo4)
                    Sections.Moves -> MovesSection(pokemonui)
                }
            }
        }
    }
}


@Composable
private fun BoxScope.SectionsContent() {
    Surface(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(MaterialTheme.colors.onBackground)
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .fillMaxHeight(0.6f)

    ) {}
}

@Composable
fun PokeballSpinning(color: Color){
    val spinningAnimation = rememberInfiniteTransition()

    val rotationAngle by spinningAnimation.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000),
            repeatMode = RepeatMode.Restart
        )
    )
    Box(modifier = Modifier.size(200.dp), contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.fillMaxSize()
                .graphicsLayer(rotationZ = rotationAngle),
            painter = painterResource(id = R.drawable.pokeballbackground),
            contentDescription = "",
            colorFilter = ColorFilter.tint(color = color.copy(0.3f))
        )
    }
}

@Composable
private fun PokemonImage(pokemon: PokemonUi) {
    Box(modifier = Modifier.size(200.dp), contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = pokemon.pokemonDrawableResourceId),
            alpha = 1.0f,
            contentDescription = "pokemonDrawableResourceId"
        )
    }
}
