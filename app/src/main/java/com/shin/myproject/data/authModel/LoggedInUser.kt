package com.shin.myproject.data.authModel

import androidx.lifecycle.ViewModel

/**
 * Data class to store logged-in user information.
 */
data class LoggedInUser(
    val userId: Int,
    val firstname: String,
    val lastname: String,
    val email: String,
    val phone: String
)

class SharedViewModel : ViewModel() {
    var loggedInUser: LoggedInUser? = null
}