package com.shin.myproject.screens.main.mainScreen.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shin.myproject.R

@Composable
fun HomeScreen(navController:NavController){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.nbslogo),
            contentDescription = "NBS LOGO"
        )
        Text(
            "Welcome to the Home Screen",
            style = TextStyle(fontSize = 25.sp, color = Color.Black)
        )
        Text(
            " ",
            style = TextStyle(fontSize = 18.sp, color = Color.Gray)
        )
    }

}