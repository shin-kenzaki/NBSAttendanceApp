package com.shin.myproject.ViewModel.subject

import androidx.lifecycle.ViewModel
import com.shin.myproject.data.mainscreenModel.subjectModel.DayListItem
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject
import com.shin.myproject.data.mainscreenModel.subjectModel.SubjectList

class SubjectAddViewModel : ViewModel() {
    fun saveSubject(
        userId: Long,
        subjectCode: String,
        subjectName: String,
        selectedDays: List<DayListItem>,
        startTime: String,
        endTime: String,
        subjectDescription: String
    ) {
        val subjectData = Subject(
            userId = userId,
            subjectCode = subjectCode,
            subjectName = subjectName,
            subjectDay = selectedDays.joinToString(", ") { it.title },
            startTime = startTime,
            endTime = endTime,
            subjectDescription = subjectDescription
        )
        SubjectList.subjects.add(subjectData)
        // You can add additional logic to save the data to a database or perform other actions.
    }
}
