package com.shin.myproject.screens.authenticationScreens.login.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.shin.myproject.R
import com.shin.myproject.ViewModel.AppViewModelProvider
import com.shin.myproject.ViewModel.user.LoginViewModel
import com.shin.myproject.navigation.routes.AuthRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var username by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(25.dp)
            .wrapContentSize(Alignment.Center)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(300.dp),
                painter = painterResource(id = R.drawable.nbslogo),
                contentDescription = "NBS LOGO"
            )
            Text(
                text = "Welcome Back",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(top = 16.dp)
            )
            Text(
                text = "Sign in to access your account",
                style = TextStyle(fontSize = 17.sp),
                modifier = Modifier
                    .padding(top = 8.dp)
            )

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = {
                    Text(
                        text = "Username/Email",
                        color = Color.Red
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray
                ),
                singleLine = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = "Email",
                        tint = Color.LightGray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        text = "Password",
                        color = Color.Red
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray
                ),
                trailingIcon = {
                    PasswordToggleIcon(passwordVisible) {
                        passwordVisible = !passwordVisible
                    }
                },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = 25.dp, vertical = 3.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val checkedState = remember { mutableStateOf(false) }
                Row(
                    modifier = Modifier
                        .padding(0.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Checkbox(
                        checked = checkedState.value,
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Red,
                            uncheckedColor = Color.Black,
                            checkmarkColor = Color.White
                        ),
                        onCheckedChange = { checkedState.value = it }
                    )

                    Text(
                        text = "Remember Me",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                ClickableText(
                    text = AnnotatedString("Forgot Password?"),
                    onClick = { navController.navigate(AuthRoute.OTPScreen.name) },
                    style = TextStyle(
                        color = Color.Red,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier.padding(end = 4.dp)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {

                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .width(450.dp)
                        .padding(vertical = 5.dp, horizontal = 25.dp)
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Log In", color = Color.White, fontSize = 14.sp)
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Log In Button",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(horizontal = 25.dp, vertical = 3.dp)
                        .width(300.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "New member?",
                        style = TextStyle(fontSize = 17.sp),
                        modifier = Modifier
                    )
                    ClickableText(
                        text = AnnotatedString("Register Now"),
                        onClick = { navController.navigate(AuthRoute.RegistrationScreen.name) },
                        style = TextStyle(
                            color = Color.Red,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun PasswordToggleIcon(passwordVisible: Boolean, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (passwordVisible) Icons.Default.LockOpen else Icons.Default.Lock,
            contentDescription = "Toggle Password Visibility",
            tint = Color.LightGray
        )
    }
}

