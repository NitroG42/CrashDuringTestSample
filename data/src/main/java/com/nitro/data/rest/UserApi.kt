package com.nitro.data.rest

import com.nitro.data.vo.User

/**
 * Created by t.coulange on 24/07/2020.
 */
interface UserApi {
    suspend fun getUser(): User
}