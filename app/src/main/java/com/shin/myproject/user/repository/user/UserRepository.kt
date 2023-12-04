package com.shin.myproject.user.repository.user

import com.shin.myproject.user.dao.UserDao
import com.shin.myproject.data.authModel.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    /**
     * Retrieve all the users from the the given data source.
     */
    fun getAllUsersStream(): Flow<List<User>>

    /**
     * Retrieve an user from the given data source that matches with the [id].
     */
    fun getUserStream(id: Int): Flow<User?>

    /**
     * Retrieve an user from the given data source that matches with the [username].
     */

    suspend fun getUserByUsername(username: String): User?

    /**
     * Retrieve a user from the given data source that matches with the [email].
     */
    suspend fun getUserByEmail(email: String): User?

    /**
     * Insert user in the data source
     */
    suspend fun insertUser(user: User)

    /**
     * Delete user from the data source
     */
    suspend fun deleteUser(user: User)

    /**
     * Update user in the data source
     */
    suspend fun updateUser(user: User)
}
