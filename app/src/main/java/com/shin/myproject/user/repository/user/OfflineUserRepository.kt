package com.shin.myproject.user.repository.user

import com.shin.myproject.data.authModel.User
import com.shin.myproject.user.dao.UserDao
import kotlinx.coroutines.flow.Flow

class OfflineUserRepository(private val userDao: UserDao) : UserRepository {
    override fun getAllUsersStream(): Flow<List<User>> = userDao.getAllUsers()

    override fun getUserStream(id: Int): Flow<User?> = userDao.getUser(id)

    override suspend fun getUserByUsername(username: String): User? {
        return userDao.getUserByUsername(username)
    }
    override suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)
    }
    override suspend fun insertUser(user: User) = userDao.insert(user)

    override suspend fun deleteUser(user: User) = userDao.delete(user)

    override suspend fun updateUser(user: User) = userDao.update(user)
}