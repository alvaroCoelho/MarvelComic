package com.marvelcomic.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.marvelcomic.R
import com.marvelcomic.ui.viewModel.CharacterComicsListViewModel
import com.marvelcomic.util.Constants


@Composable
fun ChoiceHeroScreen( navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.white_background_marvel)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.white_background_marvel)),
        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {
                Text(
                    text = stringResource(R.string.choose_hero),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.red_marvel)
                )
            }

            Row(modifier = Modifier.padding(30.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.captain_america),
                    contentDescription = "",
                    modifier = Modifier
                        .size(200.dp)
                        .clickable {
                            navController.currentBackStackEntry?.savedStateHandle?.
                            set(Constants.CHARACTER_ID, Constants.CAPTAIN_AMERICA_ID)
                            navController.navigate(Destinations.CharacterComicsListScreen.route)
                        }
                )

                Image(
                    painter = painterResource(id = R.drawable.iron_man),
                    contentDescription = "",
                    modifier = Modifier
                        .size(200.dp)
                        .clickable {
                            navController.currentBackStackEntry?.savedStateHandle?.
                            set(Constants.CHARACTER_ID, Constants.IRON_MAN_ID)
                            navController.navigate(Destinations.CharacterComicsListScreen.route)

                        }
                )
            }

            Row {
                Image(
                    painter = painterResource(id = R.drawable.hulk),
                    contentDescription = "",
                    modifier = Modifier
                        .size(200.dp)
                        .clickable {
                            navController.currentBackStackEntry?.savedStateHandle?.
                            set(Constants.CHARACTER_ID, Constants.HULK_ID)
                            navController.navigate(Destinations.CharacterComicsListScreen.route)

                        }
                )

                Image(
                    painter = painterResource(id = R.drawable.thor),
                    contentDescription = "",
                    modifier = Modifier
                        .size(200.dp)
                        .clickable {
                            navController.currentBackStackEntry?.savedStateHandle?.
                            set(Constants.CHARACTER_ID, Constants.THOR_iD)
                            navController.navigate(Destinations.CharacterComicsListScreen.route)

                        }
                )
            }

        }
    }


}