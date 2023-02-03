package com.marvelcomic.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marvelcomic.R
import com.marvelcomic.data.model.ThumbnailModel
import com.marvelcomic.data.model.comic.ComicModel


@Composable
fun CharacterComicsListScreen() {
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
                Text(
                    text = "Iron Man " + stringResource(R.string.comics),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.red_marvel)
                )
            }

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                ListComics()
            }

        }

    }


}

@Composable
fun ListComics() {

    val listComics = listOf(
        ComicModel(
            1, "comicName1", "Comic1",
            ThumbnailModel("", "")
        ),

        ComicModel(
            1, "comicName2", "Comic2",
            ThumbnailModel("", "")
        ),

        ComicModel(
            1, "comicName3", "Comic3",
            ThumbnailModel("", "")
        ),

        ComicModel(
            1, "comicName4", "Comic14",
            ThumbnailModel("", "")
        ),
        ComicModel(
            1, "comicName4", "Comic14",
            ThumbnailModel("", "")
        ), ComicModel(
            1, "comicName4", "Comic14",
            ThumbnailModel("", "")
        ),
        ComicModel(
            1, "comicName4", "Comic14",
            ThumbnailModel("", "")
        ),
        ComicModel(
            1, "comicName4", "Comic14",
            ThumbnailModel("", "")
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.white_background_marvel))
    ) {

        items(listComics) { comic ->
            ItemListComic(comic)
        }
    }
}


@Composable
fun ItemListComic(comic: ComicModel) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.captain_america),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
            )
        }

        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                text = comic.title,
                fontWeight = FontWeight.Bold
            )
        }

        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                text = comic.descrition,
                fontWeight = FontWeight.Bold
            )
        }
    }


/*    AsyncImage(
        modifier = Modifier
            .size(75.dp)
            .padding(0.dp, 5.dp, 1.dp, 0.dp)
            .clip(RoundedCornerShape(3.dp)),
        model = "url",
        contentDescription = null,
        contentScale = ContentScale.Fit
    )*/

}