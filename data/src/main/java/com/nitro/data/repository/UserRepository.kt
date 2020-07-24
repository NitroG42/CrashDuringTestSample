package com.nitro.data.repository

import com.nitro.data.db.UserDao
import com.nitro.data.rest.UserApi
import javax.inject.Inject

/**
 * Created by t.coulange on 24/07/2020.
 */
class UserRepository @Inject internal constructor(
    private val userDao: UserDao,
    private val userApi: UserApi
) {
    suspend fun fetchUser() =
        kotlin.runCatching {
            userDao.insertUser(userApi.getUser())
        }

    fun watchUser() = userDao.watchCurrentUser()
    suspend fun getUser() = userDao.getCurrentUser()
}