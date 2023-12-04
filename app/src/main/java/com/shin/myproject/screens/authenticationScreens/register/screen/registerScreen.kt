package com.shin.myproject.screens.authenticationScreens.register.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.School
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.shin.myproject.ViewModel.user.AppViewModelProvider
import com.shin.myproject.ViewModel.user.RegisterViewModel
import com.shin.myproject.ViewModel.user.UserDetails
import com.shin.myproject.navigation.routes.AuthRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()

    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }
    var school by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }

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
                painter = painterResource(id = com.shin.myproject.R.drawable.nbslogo),
                contentDescription = "NBS LOGO"
            )
            Text(
                text = "Get Started",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(top = 16.dp)
            )
            Text(
                text = "by creating free account.",
                style = TextStyle(fontSize = 17.sp),
                modifier = Modifier
                    .padding(top = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = firstname,
                    onValueChange = { firstname = it },
                    label = {
                        Text(
                            text = "First Name",
                            color = Color.Red
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Red,
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "First Name",
                            tint = Color.LightGray
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                )

                Spacer(modifier = Modifier.width(8.dp))

                OutlinedTextField(
                    value = lastname,
                    onValueChange = { lastname = it },
                    label = {
                        Text(
                            text = "Last Name",
                            color = Color.Red
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Red,
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Last name",
                            tint = Color.LightGray
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                )
            }

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = {
                    Text(
                        text = "Phone Number",
                        color = Color.Red
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.PhoneAndroid,
                        contentDescription = "phone logo",
                        tint = Color.LightGray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = {
                    Text(
                        text = "Username",
                        color = Color.Red
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray,
                ),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Username",
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
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray,
                ),

                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Lock else Icons.Default.Lock,
                            contentDescription = "Toggle Password Visibility",
                            tint = Color.LightGray
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        text = "Email",
                        color = Color.Red
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray,
                ),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = "Valid Email",
                        tint = Color.LightGray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = school,
                onValueChange = { school = it },
                label = {
                    Text(
                        text = "School",
                        color = Color.Red
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray,
                ),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.School,
                        contentDescription = "School",
                        tint = Color.LightGray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = department,
                onValueChange = { department = it },
                label = {
                    Text(
                        text = "Department (Abbreviation)",
                        color = Color.Red
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray,
                ),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.People,
                        contentDescription = "Department",
                        tint = Color.LightGray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            val termsAndConditionsText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("By checking the box, you agree to our ")
                }
                pushStyle(style = SpanStyle(color = if (isChecked.value) Color.Red else Color.Black))
                append("Terms ")
                pushStyle(style = SpanStyle(color = Color.Black))
                append("and ")
                pushStyle(style = SpanStyle(color = if (isChecked.value) Color.Red else Color.Black))
                append("Conditions.")
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp, vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked.value,
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Red,
                        uncheckedColor = Color.Black,
                        checkmarkColor = Color.White
                    ),
                    onCheckedChange = { isChecked.value = it }
                )
                ClickableText(
                    text = termsAndConditionsText,
                    onClick = { offset ->
                        if (offset >= termsAndConditionsText.length - 18) {
                            // Handle click on "Terms and Conditions" text
                        }
                    }
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            var userUiState = registerViewModel.userUiState
                            userUiState.userDetails = UserDetails(
                                username = username,
                                password = password,
                                firstname = firstname,
                                lastname = lastname,
                                phone = phone,
                                email = email,
                                school = school,
                                department = department
                            )
                            registerViewModel.saveUser()
                            Log.i("userUiState", userUiState.userDetails.toString())
                            navController.navigate(AuthRoute.LoginScreen.name)
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
                        Text(text = "Register", color = Color.White, fontSize = 14.sp)
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Register Button",
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
                        text = "Already a member?",
                        style = TextStyle(fontSize = 17.sp),
                        modifier = Modifier
                    )
                    ClickableText(
                        text = AnnotatedString("Log In"),
                        onClick = { navController.navigate(AuthRoute.LoginScreen.name) },
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