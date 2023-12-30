package com.shin.myproject.ViewModel.subject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shin.myproject.data.authModel.LoggedInUserHolder
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject
import com.shin.myproject.user.repository.subject.SubjectRepository
import kotlinx.coroutines.launch

class SubjectListViewModel(
    private val subjectRepository: SubjectRepository
) : ViewModel() {
    // userId of the loggedInUser
    private val loggedInUserId: Long = LoggedInUserHolder.getLoggedInUser()?.userId ?: -1L

    // Create a LiveData to hold the list of subjects
    private val _subjectList = MutableLiveData<List<Subject>>()
    val subjectList: LiveData<List<Subject>> get() = _subjectList

    // Function to retrieve all subjects of the loggedInUser based on their userId
    fun loadSubjects() {
        if (loggedInUserId != -1L) {
            viewModelScope.launch {
                // Use the SubjectRepository to get the subjects
                val subjects = subjectRepository.getAllSubjectsByUserId(loggedInUserId)
                _subjectList.postValue(subjects)
            }
        }
    }
}