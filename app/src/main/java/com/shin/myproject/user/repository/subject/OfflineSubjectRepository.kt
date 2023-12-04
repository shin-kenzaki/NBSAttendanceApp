package com.shin.myproject.user.repository.subject

import com.shin.myproject.data.mainscreenModel.studentModel.Student
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject
import com.shin.myproject.user.dao.SubjectDao
import kotlinx.coroutines.flow.Flow


class OfflineSubjectRepository(private val subjectDao: SubjectDao) : SubjectRepository {
    override fun getAllSubjectStream(): Flow<List<Subject>> = subjectDao.getAllSubject()

    override fun getSubjectStream(subjectId: Long): Flow<Subject?> = subjectDao.getSubject(subjectId)

    override suspend fun insertSubject(subject: Subject) = subjectDao.insert(subject)

    override suspend fun deleteSubject(subject: Subject) = subjectDao.delete(subject)

    override suspend fun updateSubject(subject: Subject) = subjectDao.update(subject)
}