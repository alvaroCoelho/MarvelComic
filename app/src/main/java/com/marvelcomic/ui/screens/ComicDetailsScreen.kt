package com.marvelcomic.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.marvelcomic.R


@Composable
fun ComicDetaisScreen(){
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
                Image(
                    painter = painterResource(id = R.drawable.captain_america),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                )
            }

            Row(modifier = Modifier.padding(5.dp)) {
                Text(
                    text = "titulo",
                    fontWeight = FontWeight.Bold
                )
            }

            Row(modifier = Modifier.padding(15.dp,5.dp,15.dp,5.dp)) {
                Text(
                    text = "Descricao Descricao Descricao Descricao Descricao Descricao " +
                            "Descricao Descricao Descricao Descricao Descricao Descricao Descricao " +
                            "Descricao Descricao Descricao Descricao Descricao Descricao ",
                    fontWeight = FontWeight.Bold
                )
            }
        }
        }

    }
