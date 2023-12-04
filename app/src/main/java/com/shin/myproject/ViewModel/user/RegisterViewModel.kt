package com.shin.myproject.ViewModel.user

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shin.myproject.data.authModel.User
import com.shin.myproject.user.repository.user.UserRepository
import kotlinx.coroutines.launch

/**
 * ViewModel to validate and insert users in the Room database.
 */
class RegisterViewModel(private val usersRepository: UserRepository) : ViewModel() {

    /**
     * Holds current user ui state
     */
    var userUiState by mutableStateOf(UserUiState())
        private set

    /**
     * Updates the [userUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(userDetails: UserDetails) {
        userUiState =
            UserUiState(userDetails = userDetails, isEntryValid = validateInput(userDetails))
    }

    /**
     * Inserts an [User] in the Room database
     */
    suspend fun saveUser() {
        Log.i("validateInput()" ,validateInput().toString())
        if (validateInput()) {
            usersRepository.insertUser(userUiState.userDetails.toUser())
        }
    }

    private fun validateInput(uiState: UserDetails = userUiState.userDetails): Boolean {
        return with(uiState) {
            username.length >= 8 &&
                    password.length >= 8 &&
                    password.any { it.isDigit() } &&
                    firstname.isNotBlank() &&
                    lastname.isNotBlank() &&
                    email.isNotBlank() &&
                    school.isNotBlank() &&
                    school.isNotBlank() &&
                    department.isNotBlank()
        }
    }
}

/**
 * Represents Ui State for an User.
 */
data class UserUiState(
    var userDetails: UserDetails = UserDetails(),
    val isEntryValid: Boolean = false
)

data class UserDetails(
    val id: Int = 0,
    val username: String = "",
    val password: String = "",
    val firstname: String ="",
    val lastname: String = "",
    val phone: String = "",
    val email: String = "",
    val school: String ="",
    val department: String ="",
)

/**
 * Extension function to convert [UserUiState] to [User]. If the value of [UserDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [UserUiState] is not a valid [Int], then the quantity will be set to 0
 */
fun UserDetails.toUser(): User = User(
    userId = id,
    username = username,
    password = password,
    firstname = firstname,
    lastname = lastname,
    phone = phone,
    email = email,
    school = school,
    department = department
)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun User.toUserUiState(isEntryValid: Boolean = false): UserUiState = UserUiState(
    userDetails = this.toUserDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun User.toUserDetails(): UserDetails = UserDetails(
    id = userId,
    username = username,
    password = password,
    firstname = firstname,
    lastname = lastname,
    phone = phone,
    email = email,
    school = school,
    department = department
)
