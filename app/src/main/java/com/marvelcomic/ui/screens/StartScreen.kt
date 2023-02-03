package com.marvelcomic.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marvelcomic.R

@Preview
@Composable
fun HomeScreen(){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.white_background_marvel)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row {
            Image(
                painter = painterResource(id = R.drawable.marvel_comics),
                contentDescription = ""
            )
        }

        Row {
            Button( modifier = Modifier
                .height(50.dp)
                .width(200.dp),
                colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.red_marvel),
                contentColor = Color.White,
                ),
                onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.start),
                fontSize = 24.sp)

            }

        }

    }
    
    
}