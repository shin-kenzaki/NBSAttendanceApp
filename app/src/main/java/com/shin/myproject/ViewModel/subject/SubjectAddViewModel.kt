package com.shin.myproject.ViewModel.subject

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.shin.myproject.ViewModel.user.UserDetails
import com.shin.myproject.ViewModel.user.UserUiState
import com.shin.myproject.ViewModel.user.toUser
import com.shin.myproject.data.authModel.User
import com.shin.myproject.data.mainscreenModel.subjectModel.DayListItem
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject
import com.shin.myproject.user.repository.subject.SubjectRepository
import com.shin.myproject.user.repository.user.UserRepository
import kotlinx.coroutines.launch

/**
 * ViewModel to validate and insert subjects in the User's Account database.
 */
class SubjectAddViewModel(private val subjectsRepository: SubjectRepository) : ViewModel() {

    /**
     * Holds current user ui state
     */
    var subjectUiState by mutableStateOf(SubjectUiState())
        private set

    /**
     * Updates the [subjectUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(subjectDetails: SubjectDetails) {
        subjectUiState =
            SubjectUiState(subjectDetails = subjectDetails, isEntryValid = validateInput(subjectDetails))
    }

    /**
     * Inserts an [Subject] in the Room database
     */
    suspend fun saveSubject() {
        Log.i("validateInput()" ,validateInput().toString())
        if (validateInput()) {
            subjectsRepository.insertSubject(subjectUiState.subjectDetails.toSubject())
        }
    }

    private fun validateInput(uiState: SubjectDetails = subjectUiState.subjectDetails): Boolean {
        return with(uiState) {
            subjectCode.isNotBlank() &&
                    subjectName.isNotBlank() &&
                    subjectDay.isNotEmpty() &&
                    startTime.isNotBlank() &&
                    endTime.isNotBlank() &&
                    subjectDescription.isNotBlank()
        }
    }
}

/**
 * Represents Ui State for an User.
 */
data class SubjectUiState(
    var subjectDetails: SubjectDetails = SubjectDetails(),
    val isEntryValid: Boolean = false
)

data class SubjectDetails(
    val userId: Int = 0,
    val subjectId: Int = 0,
    val subjectCode: String = "",
    val subjectName: String ="",
    val subjectDay: List<DayListItem> = emptyList(),
    val startTime: String = "",
    val endTime: String = "",
    val subjectDescription: String = ""
)

/**
 * Extension function to convert [UserUiState] to [User]. If the value of [UserDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [UserUiState] is not a valid [Int], then the quantity will be set to 0
 */
fun SubjectDetails.toSubject(): Subject = Subject(
    userId = userId,
    subjectId = subjectId,
    subjectCode = subjectCode,
    subjectName = subjectName,
    subjectDay = subjectDay,
    startTime = startTime,
    endTime = endTime,
    subjectDescription = subjectDescription
)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Subject.toSubjectUiState(isEntryValid: Boolean = false): SubjectUiState = SubjectUiState(
    subjectDetails = this.toSubjectDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Subject.toSubjectDetails(): SubjectDetails = SubjectDetails(
    userId = userId,
    subjectId = subjectId,
    subjectCode = subjectCode,
    subjectName = subjectName,
    subjectDay = subjectDay,
    startTime = startTime,
    endTime = endTime,
    subjectDescription = subjectDescription
)
