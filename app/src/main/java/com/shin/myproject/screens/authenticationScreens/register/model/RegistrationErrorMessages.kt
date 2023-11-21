package com.shin.myproject.screens.authenticationScreens.register.model

data class RegistrationErrorMessages(
    val firstName: String = "",
    val lastName: String = "",
    val phone: String = "",
    val email: String = "",
    val password: String = ""
)