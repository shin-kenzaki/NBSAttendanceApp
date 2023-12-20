package com.shin.myproject.user.repository.user

import com.shin.myproject.data.authModel.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    /**
     * Retrieve all the users from the given data source.
     */
    fun getAllUsersStream(): Flow<List<User>>

    /**
     * Retrieve a user from the given data source that matches with the [id].
     */
    fun getUserStream(id: Int): Flow<User?>

    /**
     * Retrieve a user from the given data source that matches with the [userId].
     */
    suspend fun getUserById(userId: Int): User?

    /**
     * Check if a user with the given phone number exists.
     */
    fun isPhoneExist(phone: String): Flow<Boolean>

    /**
     * Check if a user with the given email exists.
     */
    fun isEmailExist(email: String): Flow<Boolean>

    /**
     * Insert user into the data source.
     */
    suspend fun insertUser(user: User)

    /**
     * Delete user from the data source.
     */
    suspend fun deleteUser(user: User)

    /**
     * Update user in the data source.
     */
    suspend fun updateUser(user: User)
}