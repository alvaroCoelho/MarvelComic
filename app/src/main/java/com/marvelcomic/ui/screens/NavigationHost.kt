package com.marvelcomic.ui.screens


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marvelcomic.data.model.comic.ComicModel
import com.marvelcomic.ui.screens.Destinations.*
import com.marvelcomic.util.Constants.CHARACTER_COMIC_LIST_SCREEN
import com.marvelcomic.util.Constants.CHARACTER_ID
import com.marvelcomic.util.Constants.CHOICE_CHARACTER_SCREEN
import com.marvelcomic.util.Constants.COMIC
import com.marvelcomic.util.Constants.COMIC_DETAILS_SCREEN
import com.marvelcomic.util.Constants.START_SCREEN
import kotlinx.coroutines.CoroutineScope


@Composable
fun NavigationHost(navController: NavHostController, scope: CoroutineScope) {

    NavHost(navController = navController, startDestination = StartScreen.route) {
        composable(StartScreen.route) {
            StartScreen(navController)
        }

        composable(CharacterComicsListScreen.route) {
            val comic = navController.previousBackStackEntry?.savedStateHandle?.get<Int>(
                CHARACTER_ID
            )
            comic?.let {
                CharacterComicsListScreen(
                    characterId = it,
                    navController = navController
                )
            }

        }

        composable(ChoiceCharacterScreen.route) {
            ChoiceHeroScreen(navController)
        }

        composable(ComicDetailsScreen.route) {
            val comic = navController.previousBackStackEntry?.savedStateHandle?.get<ComicModel>(
                COMIC
            )
            comic?.let { ComicDetaisScreen(it) }
        }

    }

}


sealed class Destinations(
    val route: String
) {
    object StartScreen : Destinations(START_SCREEN)
    object CharacterComicsListScreen : Destinations(CHARACTER_COMIC_LIST_SCREEN)
    object ChoiceCharacterScreen : Destinations(CHOICE_CHARACTER_SCREEN)
    object ComicDetailsScreen : Destinations(COMIC_DETAILS_SCREEN)
}