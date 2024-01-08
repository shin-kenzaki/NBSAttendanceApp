package com.shin.myproject.ViewModel.profile

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.shin.myproject.data.authModel.LoggedInUserHolder
import com.shin.myproject.navigation.routes.Routes
import com.shin.myproject.user.repository.user.UserRepository

class SettingsViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    fun logout() {
        // Clear the logged-in user data
        LoggedInUserHolder.clearLoggedInUser()
    }
}