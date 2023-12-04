package com.shin.myproject.ViewModel.student

import androidx.lifecycle.ViewModel
import com.shin.myproject.data.mainscreenModel.studentModel.Student
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StudentScreenViewModel : ViewModel() {

    private val _students = MutableStateFlow<List<Student>>(emptyList())
    val students = _students.asStateFlow()

    fun setStudents(students: List<Student>) {
        _students.value = students
    }
}