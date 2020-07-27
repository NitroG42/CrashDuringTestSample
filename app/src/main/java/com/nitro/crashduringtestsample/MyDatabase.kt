package com.nitro.crashduringtestsample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by nitro on 24/07/2020.
 * Without a DB to listen, no crash
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