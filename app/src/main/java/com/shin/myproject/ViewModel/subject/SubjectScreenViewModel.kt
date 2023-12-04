package com.shin.myproject.ViewModel.subject

import androidx.lifecycle.ViewModel
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SubjectScreenViewModel : ViewModel() {

    private val _subjects = MutableStateFlow<List<Subject>>(emptyList())
    val subjects = _subjects.asStateFlow()

    // Function to update the list of subjects
    fun setSubjects(subjects: List<Subject>) {
        _subjects.value = subjects
    }
}