package com.marvelcomic.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.marvelcomic.R
import com.marvelcomic.data.model.comic.ComicModel


@Composable
fun ComicDetaisScreen(comic: ComicModel) {
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
                    .padding(40.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(180.dp),
                    model = comic.thumbnailModel.path + "." + comic.thumbnailModel.extension,
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }

            Row(modifier = Modifier.padding(5.dp)) {
                comic.title?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Row(modifier = Modifier.padding(15.dp, 5.dp, 15.dp, 5.dp)) {
                comic.descrition?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

}
