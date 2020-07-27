package com.nitro.crashduringtestsample

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by nitro on 24/07/2020.
 */
@Entity
data class User(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    //Without a second field no crash
    val name: String = "test"
)