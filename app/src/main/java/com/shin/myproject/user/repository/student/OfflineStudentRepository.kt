package com.shin.myproject.user.repository.student

import com.shin.myproject.data.mainscreenModel.studentModel.Student
import com.shin.myproject.user.dao.StudentDao
import kotlinx.coroutines.flow.Flow


class OfflineStudentRepository(private val studentDao: StudentDao) : StudentRepository {
    override suspend fun insertStudent(student: Student) = studentDao.insert(student)

    override suspend fun deleteStudent(student: Student) = studentDao.delete(student)

    override suspend fun updateStudent(student: Student) = studentDao.update(student)
}