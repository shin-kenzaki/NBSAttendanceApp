package com.shin.myproject.screens.authenticationScreens.register.screen

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhoneAndroid
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
import androidx.navigation.NavController
import com.shin.myproject.navigation.routes.AuthRoute
import com.shin.myproject.navigation.routes.Routes
import com.shin.myproject.screens.authenticationScreens.register.model.NewUser
import com.shin.myproject.screens.authenticationScreens.register.model.RegistrationErrorMessages
import com.shin.myproject.screens.authenticationScreens.register.model.RegistrationObject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController : NavController) {
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var isFirstnameValid by remember { mutableStateOf(false) }
    var isLastnameValid by remember { mutableStateOf(false) }

    var phone = remember { mutableStateOf("") }
    var isPhoneValid by remember { mutableStateOf(false) }

    var email by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf(false) }
    val emailRegex = Regex("^[a-zA-Z0-9._%+-]+@(gmail\\.com|\\w+@\\w+\\.\\w+\\.\\w+\\.\\w+)$")

    var passwordVisible by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var isPasswordValid by remember { mutableStateOf(false) }
    val passwordRegex = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$")

    val isChecked = remember { mutableStateOf(false) }

    var errorMessages by remember { mutableStateOf(RegistrationErrorMessages()) }

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

            // Fullname divided into Firstname and Lastname
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = firstname,
                    onValueChange = { newFirstname ->
                        firstname = newFirstname
                        isFirstnameValid =
                            newFirstname.isNotBlank() && newFirstname[0].isUpperCase()
                    },
                    label = {
                        Text(
                            text = "First Name",
                            color = if (isFirstnameValid) Color.Red else Color.Gray
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Red,
                        unfocusedIndicatorColor = Color.Gray
                    ),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "First Name",
                            tint = if (isFirstnameValid) Color.Red else Color.Gray
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )

                OutlinedTextField(
                    value = lastname,
                    onValueChange = { newLastname ->
                        lastname = newLastname
                        isLastnameValid = newLastname.isNotBlank() && newLastname[0].isUpperCase()
                    },
                    label = {
                        Text(
                            text = "Last Name",
                            color = if (isLastnameValid) Color.Red else Color.Gray
                        )
                    }, colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Red,
                        unfocusedIndicatorColor = Color.Gray
                    ),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Last name",
                            tint = if (isLastnameValid) Color.Red else Color.Gray
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
            }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                        .wrapContentWidth(align = Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    if (errorMessages.firstName.isNotBlank()) {
                        Text(
                            text = errorMessages.firstName,
                            color = Color.Red,
                            modifier = Modifier.padding(horizontal = 25.dp, vertical = 4.dp)
                        )
                    }

                    if (errorMessages.lastName.isNotBlank()) {
                        Text(
                            text = errorMessages.lastName,
                            color = Color.Red,
                            modifier = Modifier.padding(horizontal = 25.dp, vertical = 4.dp)
                        )
                    }
                }

            OutlinedTextField(
                value = phone.value,
                onValueChange = { newPhone ->
                    phone.value = newPhone
                    isPhoneValid = newPhone.matches(Regex("\\d{11,12}"))
                },
                label = {
                    Text(
                        text = "Phone Number",
                        color = if (isPhoneValid) Color.Red else Color.Gray
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Transparent,
                    focusedBorderColor = if (isPhoneValid) Color.Gray else Color.Red,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = if (isPhoneValid) Color.Gray else Color.Red,
                    unfocusedLabelColor = Color.Gray
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.PhoneAndroid,
                        contentDescription = "phone logo",
                        tint = if (phone.value.matches(Regex("\\d{11}"))) Color.Red else Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )

            if (errorMessages.phone.isNotBlank()) {
                Text(
                    text = errorMessages.phone,
                    color = Color.Red,
                    modifier = Modifier.padding(horizontal = 25.dp, vertical = 4.dp)
                )
            }

            OutlinedTextField(
                value = email,
                onValueChange = { newEmail ->
                    email = newEmail
                    isEmailValid = newEmail.matches(emailRegex)
                },
                label = {
                    Text(
                        text = "Email",
                        color = if (isEmailValid) Color.Red else Color.Gray
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray
                ),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = "Valid Email",
                        tint = if (isEmailValid) Color.Red else Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )

            if (errorMessages.email.isNotBlank()) {
                Text(
                    text = errorMessages.email,
                    color = Color.Red,
                    modifier = Modifier.padding(horizontal = 25.dp, vertical = 4.dp)
                )
            }

            OutlinedTextField(
                value = password,
                onValueChange = { newPassword ->
                    password = newPassword
                    isPasswordValid = passwordRegex.matches(newPassword)
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
                    .padding(horizontal = 10.dp)
            )

            if (errorMessages.password.isNotBlank()) {
                Text(
                    text = errorMessages.password,
                    color = Color.Red,
                    modifier = Modifier.padding(horizontal = 25.dp, vertical = 4.dp)
                )
            }

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
                    onClick = {// Clear previous error messages
                        errorMessages = RegistrationErrorMessages()

                        // Check input validations
                        if (firstname.isBlank() || !firstname[0].isUpperCase()) {
                            errorMessages = errorMessages.copy(firstName = "Firstname should start with a capital letter")
                        }

                        if (lastname.isBlank() || !lastname[0].isUpperCase()) {
                            errorMessages = errorMessages.copy(lastName = "Lastname should start with a capital letter")
                        }

                        if (!phone.value.matches(Regex("\\d{11,12}"))) {
                            errorMessages = errorMessages.copy(phone = "Invalid phone number")
                        }

                        if (!email.matches(emailRegex)) {
                            errorMessages = errorMessages.copy(email = "Invalid email address")
                        }

                        if (!passwordRegex.matches(password)) {
                            errorMessages = errorMessages.copy(password = "Password should be 8 characters with at least one number")
                        }

                        // Check if there are no errors and the checkbox is checked
                        if (errorMessages == RegistrationErrorMessages() && isChecked.value) {
                            // Save the inputted data into NewUser object
                            val newUser = NewUser(
                                firstName = firstname,
                                lastName = lastname,
                                phoneNumber = phone.value,
                                email = email,
                                password = password
                                // Add more properties as needed
                            )

                            // Save the NewUser object in the RegistrationObject.userList
                            RegistrationObject.userList.add(newUser)

                            navController.navigate(route = Routes.REGISTERSPLASH.name)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = if (isFirstnameValid && isLastnameValid && isPhoneValid && isEmailValid && isPasswordValid) Color.Red else Color.Gray),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .width(450.dp)
                        .padding(vertical = 5.dp, horizontal = 25.dp),
                    enabled = isFirstnameValid && isLastnameValid && isPhoneValid && isEmailValid && isPasswordValid
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