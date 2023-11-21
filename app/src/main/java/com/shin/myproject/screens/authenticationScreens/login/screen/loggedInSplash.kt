package com.shin.myproject.screens.authenticationScreens.login.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.shin.myproject.ViewModel.ScreenViewModel
import com.shin.myproject.navigation.routes.Routes

@Composable
fun LoggedInSplash(
    navController: NavHostController,
    screenViewModel: ScreenViewModel,
) {
    val state = screenViewModel.isLoggedin.collectAsState()
    screenViewModel.loginUser()

    if (state.value) {
        navController.navigate(Routes.MAIN.name)
    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Logging In",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.padding(16.dp))

            Box(Modifier.height(25.dp))
            LinearProgressIndicator(
                modifier = Modifier.width(150.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                trackColor = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}
