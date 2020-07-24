package com.nitro.data.vo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by t.coulange on 24/07/2020.
 */
@Entity
data class User(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String
)