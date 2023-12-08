package com.shin.myproject.user.repository.currentUser

import com.shin.myproject.data.authModel.CurrentUser
import com.shin.myproject.data.authModel.User

interface CurrentUserRepository {
    suspend fun getCurrentUser(): CurrentUser?
    suspend fun insertCurrentUser(currentUser: User)
    suspend fun clearCurrentUser()
}
