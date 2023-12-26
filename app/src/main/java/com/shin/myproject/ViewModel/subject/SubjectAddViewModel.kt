package com.shin.myproject.ViewModel.subject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shin.myproject.data.authModel.SharedViewModel
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject
import com.shin.myproject.user.repository.subject.SubjectRepository
import kotlinx.coroutines.launch

/**
 * ViewModel to validate and insert subjects in the User's Account database.
 */
class SubjectAddViewModel(
    private val subjectRepository: SubjectRepository,
    private val sharedViewModel: SharedViewModel
) : ViewModel() {

    fun saveSubject(
        subjectCode: String,
        subjectName: String,
        subjectDay: String,
        startTime: String,
        endTime: String,
        subjectDescription: String
    ) {
        val loggedInUser = sharedViewModel.loggedInUser
        if (loggedInUser == null) {
            // Handle the case where loggedInUser is null
            return
        }

        val newSubject = Subject(
            userId = loggedInUser.userId,
            subjectCode = subjectCode,
            subjectName = subjectName,
            subjectDay = subjectDay,
            startTime = startTime,
            endTime = endTime,
            subjectDescription = subjectDescription
        )

        viewModelScope.launch {
            subjectRepository.insertSubject(newSubject)
        }
    }

    // You can add additional functions for updating or deleting subjects if needed.
}