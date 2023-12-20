package com.shin.myproject.ViewModel.user

import androidx.lifecycle.ViewModel
import com.shin.myproject.user.repository.user.UserRepository

/**
 * ViewModel for the login screen.
 */
class LoginViewModel(
    private val usersRepository: UserRepository
) : ViewModel() {

}
