package com.shin.myproject.ViewModel.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.shin.myproject.data.authModel.User
import com.shin.myproject.user.repository.currentUser.CurrentUserRepository
import com.shin.myproject.user.repository.user.UserRepository

/**
 * ViewModel for the login screen.
 */
class LoginViewModel(private val userRepository: UserRepository, private val currentUserRepository: CurrentUserRepository) : ViewModel() {

    // Mutable state for UI interaction
    var isUsernameValid by mutableStateOf(false)
        private set

    var isPasswordValid by mutableStateOf(false)
        private set

    var showError by mutableStateOf(false)
        private set

    var currentUser: User? by mutableStateOf(null)
        private set

    // Example usage in another ViewModel or Activity
    val currentLoggedInUser: User? = CurrentUserHolder.currentUser

    /**
     * Validate the input username and password.
     */
    fun validateInput(usernameOrEmail: String, password: String): Boolean {
        isUsernameValid = usernameOrEmail.isNotEmpty()
        isPasswordValid = password.isNotEmpty()

        return isUsernameValid && isPasswordValid
    }

    /**
     * Attempt to log in the user.
     */
    suspend fun loginUser(usernameOrEmail: String, password: String): Boolean {
        if (validateInput(usernameOrEmail, password)) {
            val user = userRepository.getUserByUsername(usernameOrEmail)

            // Check if the user is not found by username, try with email
            val userByEmail =
                if (user == null) userRepository.getUserByEmail(usernameOrEmail) else null

            if ((user != null && user.password == password) || (userByEmail != null && userByEmail.password == password)) {
                // Successfully logged in
                showError = false
                currentUser = user ?: userByEmail // Set the current user

                // Retrieve additional user information from userRepository
                val fullUser = userRepository.getUserById(currentUser?.userId ?: -1)
                fullUser?.let {
                    // Store the current user information into current user repository
                    currentUserRepository.insertCurrentUser(it)
                }

                return true
            }
        }
        // Login failed
        showError = true
        return false
    }
}


object CurrentUserHolder {
    var currentUser: User? = null
        private set

    fun setCurrentUser(user: User) {
        currentUser = user
    }
}

