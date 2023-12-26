package com.shin.myproject.ViewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.shin.myproject.NBSAttendanceApp
import com.shin.myproject.ViewModel.subject.SubjectAddViewModel
import com.shin.myproject.ViewModel.user.LoginViewModel
import com.shin.myproject.ViewModel.user.RegisterViewModel
import com.shin.myproject.data.authModel.SharedViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {

        // Initializer for RegistrationViewModel
        initializer {
            RegisterViewModel(
                  nbsAttendanceApplication().container.userRepository
            )
        }

        // Initializer for LoginViewModel
        initializer {
            LoginViewModel(
                nbsAttendanceApplication().container.userRepository,
                SharedViewModel()
            )
        }

        // Initializer for SubjectViewModel
        initializer {
            SubjectAddViewModel (
                nbsAttendanceApplication().container.subjectRepository,
                SharedViewModel()
            )
        }

        // ScreenViewModel
        initializer {
            ScreenViewModel()
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [NBSApplication].
 */
fun CreationExtras.nbsAttendanceApplication(): NBSAttendanceApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as NBSAttendanceApp)