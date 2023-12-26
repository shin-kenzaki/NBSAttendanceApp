package com.shin.myproject.screens.main.mainScreen.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun HomeScreen(navController: NavController) {
    var currentTime by remember { mutableStateOf(LocalDateTime.now()) }

    LaunchedEffect(key1 = Unit) {
        while (true) {
            delay(1000)
            currentTime = LocalDateTime.now()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ClockFace(currentTime = currentTime)
    }
}


@Composable
fun ClockFace(currentTime: LocalDateTime) {
    val formatter = DateTimeFormatter.ofPattern("hh:mm:ss a")
    val pstTime = currentTime.atZone(ZoneId.of("Asia/Manila")).format(formatter)

    Box(
        modifier = Modifier
            .size(250.dp)
            .clip(CircleShape)
            .background(color = Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = pstTime,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}