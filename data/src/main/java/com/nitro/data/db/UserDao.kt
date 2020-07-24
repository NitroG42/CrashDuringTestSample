package com.nitro.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nitro.data.vo.User
import kotlinx.coroutines.flow.Flow

/**
 * Created by t.coulange on 24/07/2020.
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM USER LIMIT 1")
    fun watchCurrentUser(): Flow<User?>

    @Query("SELECT * FROM USER LIMIT 1")
    suspend fun getCurrentUser(): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Query("DELETE FROM USER")
    suspend fun deleteUsers()
}