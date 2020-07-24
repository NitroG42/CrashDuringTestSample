package com.nitro.data.db

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by t.coulange on 24/07/2020.
 */
@Module
@InstallIn(ApplicationComponent::class)
class DbModule {
    @Provides
    @Singleton
    internal fun provideDatabase(@ApplicationContext context: Context): MyDatabase =
        MyDatabase.databaseBuilder(context)
}