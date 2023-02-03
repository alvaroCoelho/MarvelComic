package com.marvelcomic.ui.screens


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.CoroutineScope
import com.marvelcomic.util.Constants.CHARACTER_COMIC_LIST_SCREEN
import com.marvelcomic.util.Constants.CHOICE_CHARACTER_SCREEN
import com.marvelcomic.util.Constants.COMIC_DETAILS_SCREEN
import com.marvelcomic.util.Constants.START_SCREEN
import com.marvelcomic.ui.screens.Destinations.StartScreen
import com.marvelcomic.ui.screens.Destinations.CharacterComicsListScreen
import com.marvelcomic.ui.screens.Destinations.ChoiceCharacterScreen
import com.marvelcomic.ui.screens.Destinations.ComicDetailsScreen


@Composable
fun NavigationHost(navController: NavHostController, scope: CoroutineScope) {

    NavHost(navController = navController, startDestination = StartScreen.route) {
        composable(StartScreen.route){
            StartScreen(navController)
        }

        composable(CharacterComicsListScreen.route){
            CharacterComicsListScreen()
        }

        composable(ChoiceCharacterScreen.route){
            ChoiceHeroScreen()
        }

        composable(ComicDetailsScreen.route){
            ComicDetaisScreen()
        }

    }

}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route

}

sealed class Destinations(
    val route: String,
    val title: String
) {
    object StartScreen : Destinations(START_SCREEN, "Home")
    object CharacterComicsListScreen : Destinations(CHARACTER_COMIC_LIST_SCREEN, "List of Comics")
    object ChoiceCharacterScreen : Destinations(CHOICE_CHARACTER_SCREEN, "Choose a character")
    object ComicDetailsScreen : Destinations(COMIC_DETAILS_SCREEN, "Details")
}