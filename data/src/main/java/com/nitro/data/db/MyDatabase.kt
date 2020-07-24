package com.nitro.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nitro.data.vo.User

/**
 * Created by t.coulange on 24/07/2020.
 */
@Database(entities = [User::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun databaseBuilder(context: Context) = Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            "database.db"
        ).fallbackToDestructiveMigration().build()
    }
}