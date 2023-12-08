package com.shin.myproject.user.repository.currentUser

import com.shin.myproject.data.authModel.CurrentUser
import com.shin.myproject.data.authModel.User
import com.shin.myproject.user.dao.CurrentUserDao
import com.shin.myproject.user.repository.user.UserRepository

class CurrentUserOfflineRepository(
    private val currentUserDao: CurrentUserDao,
    private val userRepository: UserRepository
) : CurrentUserRepository {
    override suspend fun getCurrentUser(): CurrentUser? = currentUserDao.getCurrentUser()

    override suspend fun insertCurrentUser(currentUser: User) {
        val currentUserEntity = CurrentUser(
            userId = currentUser.userId,
            username = currentUser.username,
            password = currentUser.password,
            firstname = currentUser.firstname,
            lastname = currentUser.lastname,
            phone = currentUser.phone,
            email = currentUser.email,
            school = currentUser.school,
            department = currentUser.department
        )
        currentUserDao.insertCurrentUser(currentUserEntity)
    }

    override suspend fun clearCurrentUser() {
        currentUserDao.clearCurrentUser()
    }
}