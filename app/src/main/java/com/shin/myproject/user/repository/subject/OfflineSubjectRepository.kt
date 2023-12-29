package com.shin.myproject.user.repository.subject

import com.shin.myproject.data.mainscreenModel.subjectModel.Subject
import com.shin.myproject.user.dao.SubjectDao


class OfflineSubjectRepository(private val subjectDao: SubjectDao) : SubjectRepository {
    override suspend fun insertSubject(subject: Subject) = subjectDao.insert(subject)

    override suspend fun deleteSubject(subject: Subject) = subjectDao.delete(subject)

    override suspend fun updateSubject(subject: Subject) = subjectDao.update(subject)
    override suspend fun getSubjectByCode(code: String): Subject? {
        return subjectDao.getSubjectByCode(code)
    }

    override suspend fun getSubjectsByUserIdAndDay(userId: Long, day: String): List<Subject> {
        return subjectDao.getSubjectsByUserIdAndDay(userId, day)
    }
}