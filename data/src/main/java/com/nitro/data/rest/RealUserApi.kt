package com.nitro.data.rest

import com.nitro.data.vo.User
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * Created by t.coulange on 24/07/2020.
 */
class RealUserApi @Inject constructor() : UserApi {
    override suspend fun getUser(): User {
        delay(1000)
        return User("1", "Real User")
    }
}