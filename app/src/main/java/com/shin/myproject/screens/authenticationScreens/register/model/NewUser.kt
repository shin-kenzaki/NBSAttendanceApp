package com.shin.myproject.screens.authenticationScreens.register.model

import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.model.SubjectData

data class NewUser(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val password: String,
    val subjects: List<SubjectData> = emptyList() // Initialize with an empty list
)