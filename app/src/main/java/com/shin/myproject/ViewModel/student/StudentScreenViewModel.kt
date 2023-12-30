package com.shin.myproject.ViewModel.student

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shin.myproject.data.mainscreenModel.studentModel.Student
import com.shin.myproject.user.repository.student.StudentRepository
import com.shin.myproject.user.repository.subject.SubjectRepository
import kotlinx.coroutines.launch

class StudentListViewModel (
    private val studentRepository: StudentRepository,
    private val subjectRepository: SubjectRepository
) : ViewModel() {

    // Mutable variable to hold the subjectId of the clicked subject
    private val _selectedSubjectId = MutableLiveData<Long>()
    val selectedSubjectId: LiveData<Long> get() = _selectedSubjectId

    // LiveData to hold the list of students for the selected subject
    private val _studentsForSelectedSubject = MutableLiveData<List<Student>>()
    val studentsForSelectedSubject: LiveData<List<Student>> get() = _studentsForSelectedSubject

    private val _selectedSubjectCode = MutableLiveData<String>()
    val selectedSubjectCode: LiveData<String> get() = _selectedSubjectCode

    private val _selectedSubjectName = MutableLiveData<String>()
    val selectedSubjectName: LiveData<String> get() = _selectedSubjectName

    // Function to handle subject click and update the selectedSubjectId
    fun onSubjectClicked(subjectId: Long) {
        _selectedSubjectId.value = subjectId
        loadStudentsForSelectedSubject()
        loadSubjectCode()
        loadSubjectName()
    }

    // Function to retrieve all students for the selected subject
    private fun loadStudentsForSelectedSubject() {
        val subjectId = _selectedSubjectId.value ?: return

        viewModelScope.launch {
            studentRepository.getStudentsForSubject(subjectId).collect { students ->
                _studentsForSelectedSubject.value = students
            }
        }
    }

    fun loadSubjectCode() {
        val subjectId = _selectedSubjectId.value ?: return

        viewModelScope.launch {
            subjectRepository.getSubjectById(subjectId)?.let { subject ->
                _selectedSubjectCode.value = subject.subjectCode
            }
        }
    }

    fun loadSubjectName() {
        val subjectId = _selectedSubjectId.value ?: return

        viewModelScope.launch {
            subjectRepository.getSubjectById(subjectId)?.let { subject ->
                _selectedSubjectName.value = subject.subjectName
            }
        }
    }
}