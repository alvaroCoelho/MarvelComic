package com.marvelcomic.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.marvelcomic.R
import com.marvelcomic.data.model.comic.ComicModel
import com.marvelcomic.ui.viewModel.CharacterComicsListViewModel
import com.marvelcomic.ui.viewModel.ResourceState
import com.marvelcomic.util.Constants.COMIC


@Composable
fun CharacterComicsListScreen(
    characterId: Int,
    navController: NavController,
    viewModel: CharacterComicsListViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = characterId){
        viewModel.fetch(characterId)
    }

    var currentState = viewModel.list.value
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.white_background_marvel)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                when (currentState) {
                    ResourceState.Empty -> ListAppsEmpty()
                    is ResourceState.Success -> ListComics(
                        listComics = currentState.allComics,
                        navController
                    )
                    is ResourceState.Loading -> ListAppsLoading()
                }
            }

        }

    }


}

@Composable
fun ListComics(listComics: List<ComicModel>, navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.white_background_marvel))
    ) {
        items(listComics) { comic ->

            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .clickable {
                        navController.currentBackStackEntry?.savedStateHandle?.set(COMIC, comic)
                        navController.navigate(Destinations.ComicDetailsScreen.route)

                    },
                elevation = 10.dp,
            ) {
                ItemListComic(comic, navController)
            }


        }
    }
}


@Composable
fun ItemListComic(comic: ComicModel, navController: NavController) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(180.dp),
                model = comic.thumbnailModel.path+"."+comic.thumbnailModel.extension,
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }

        Row(modifier = Modifier.padding(5.dp)) {
            comic.title?.let {
                Text(
                    text = it, fontWeight = FontWeight.Bold
                )
            }
        }

        Row(modifier = Modifier.padding(5.dp)) {
            comic.descrition?.let {
                Text(
                    text = it, fontWeight = FontWeight.Bold
                )
            }
        }
    }




}


@Composable
fun ListAppsEmpty() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(0.dp, 5.dp)
            .background(Color.White)
            .padding(0.dp, 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.empty),
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ListAppsLoading() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(0.dp, 5.dp)
            .background(Color.White)
    ) {


        Text(
            text = stringResource(R.string.loading),
            color = Color.Gray,
            fontSize = 20.sp
        )
    }
}