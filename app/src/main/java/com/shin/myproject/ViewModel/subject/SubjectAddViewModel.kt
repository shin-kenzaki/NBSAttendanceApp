package com.shin.myproject.ViewModel.subject

import androidx.lifecycle.ViewModel
import com.shin.myproject.data.authModel.LoggedInUserHolder
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject
import com.shin.myproject.user.repository.subject.SubjectRepository

//Dataclass that will hold the data from input screen
data class SubjectAddInputs(
    val subjectCode: String,
    val subjectName: String,
    val subjectDay: String,
    val startTime: String,
    val endTime: String,
    val subjectDescription: String
)


/**
 * ViewModel to validate and insert subjects in the User's Account database.
 */
class SubjectAddViewModel(
    private val subjectRepository: SubjectRepository
) : ViewModel() {

    private val loggedInUserId: Long = LoggedInUserHolder.getLoggedInUser()?.userId ?: -1L

    private suspend fun isSubjectCodeUnique(subjectCode: String): Boolean {
        return subjectRepository.getSubjectByCode(subjectCode) == null
    }

    private suspend fun isScheduleValid(
        subjectDay: String,
        startTime: String,
        endTime: String
    ): Boolean {
        val userSubjectsOnDay = subjectRepository.getSubjectsByUserIdAndDay(loggedInUserId, subjectDay)

        for (subject in userSubjectsOnDay) {
            if (doSchedulesOverlap(startTime, endTime, subject.startTime, subject.endTime)) {
                return false // Overlap detected
            }
        }

        return true // No overlap detected
    }

    private fun doSchedulesOverlap(
        startTime1: String,
        endTime1: String,
        startTime2: String,
        endTime2: String
    ): Boolean {
        val start1 = convertToMinutes(startTime1)
        val end1 = convertToMinutes(endTime1)
        val start2 = convertToMinutes(startTime2)
        val end2 = convertToMinutes(endTime2)

        return (start1 < end2 && end1 > start2)
    }

    private fun convertToMinutes(timeString: String): Int {
        val parts = timeString.split(":")
        return if (parts.size == 2) {
            parts[0].toInt() * 60 + parts[1].toInt()
        } else {
            0
        }
    }

    suspend fun insertSubject(subjectAddInputs: SubjectAddInputs): SubjectAddResult {
        val (subjectCode, subjectName, subjectDay, startTime, endTime, subjectDescription) = subjectAddInputs

        if (!isSubjectCodeUnique(subjectCode)) {
            return SubjectAddResult.Failure("Subject code already exists")
        }

        if (!isScheduleValid(subjectDay, startTime, endTime)) {
            return SubjectAddResult.Failure("Schedule overlap detected")
        }

        val subject = Subject(
            userId = loggedInUserId,
            subjectCode = subjectCode,
            subjectName = subjectName,
            subjectDay = subjectDay,
            startTime = startTime,
            endTime = endTime,
            subjectDescription = subjectDescription
        )

        subjectRepository.insertSubject(subject)
        return SubjectAddResult.Success("Subject added successfully")
    }
}

sealed class SubjectAddResult {
    data class Success(val message: String) : SubjectAddResult()
    data class Failure(val errorMessage: String) : SubjectAddResult()
}