package com.shin.myproject.data

import android.content.Context
import com.shin.myproject.user.repository.user.OfflineUserRepository
import com.shin.myproject.user.repository.user.UserRepository

interface AppContainer {
    val userRepository: UserRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineUserRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [userRepository]
     */
    override val userRepository: UserRepository by lazy {
        OfflineUserRepository(AttendanceAppDatabase.getDatabase(context).userDao())
    }
}
