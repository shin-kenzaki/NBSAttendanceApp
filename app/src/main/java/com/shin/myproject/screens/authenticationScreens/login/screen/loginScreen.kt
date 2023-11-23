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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.shin.myproject.R
import com.shin.myproject.navigation.routes.AuthRoute
import com.shin.myproject.navigation.routes.Routes
import com.shin.myproject.screens.authenticationScreens.register.model.NewUser
import com.shin.myproject.screens.authenticationScreens.register.model.RegistrationObject
import com.shin.myproject.screens.main.mainScreen.subject.screen.addsubjectscreen.embeddedSubjects


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen( navController: NavHostController ) {

    var username by remember { mutableStateOf("") }
    var isUsernameValid by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var isPasswordValid by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }
    val defaultUser = remember {
        NewUser("user1", "", "", "user1@gmail.com", "password1", embeddedSubjects())
    }
    RegistrationObject.userList.add(defaultUser)
    val loginDataList = remember {
        // Use the RegistrationObject.userList instead of a separate list
        RegistrationObject.userList
    }

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
                onValueChange = { newUsername ->
                    username = newUsername
                    isUsernameValid = newUsername.isNotEmpty()
                },
                label = {
                    Text(
                        text = "Username",
                        color = if (isUsernameValid) Color.Red else Color.Gray
                    )
                },
                singleLine = true, // Set singleLine to true
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray
                ),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = "Email",
                        tint = if (isUsernameValid) Color.Red else Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { newPassword ->
                    password = newPassword
                    isPasswordValid = newPassword.isNotEmpty()
                },
                label = {
                    Text(
                        text = "Password",
                        color = if (isPasswordValid) Color.Red else Color.Gray
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray
                ),

                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Lock else Icons.Default.Lock,
                            contentDescription = "Toggle Password Visibility",
                            tint = if (passwordVisible) Color.Gray else if (password.isNotEmpty()) Color.Red else Color.Gray
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
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
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                ClickableText(
                    text = AnnotatedString("Forgot Password?"),
                    onClick = { navController.navigate(AuthRoute.OTPScreen.name) },
                    style = TextStyle(
                        color = Color.Red,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            if (showError) {
                Text(
                    text = "Incorrect username or password",
                    color = Color.Red,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        val foundUser = loginDataList.find { it.email == username && it.password == password }
                        if (foundUser != null) {
                            // Use the subjects associated with the logged-in user
                            val userSubjects = foundUser.subjects
                            // Further processing...
                            navController.navigate(route = Routes.LOGINSPLASH.name)
                        } else {
                            showError = true
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