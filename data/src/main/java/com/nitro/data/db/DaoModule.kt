package com.nitro.data.db

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * Created by t.coulange on 24/07/2020.
 */
@Module
@InstallIn(ApplicationComponent::class)
class DaoModule {
    @Provides
    fun userDao(mydatabase: MyDatabase): UserDao = mydatabase.userDao()
}