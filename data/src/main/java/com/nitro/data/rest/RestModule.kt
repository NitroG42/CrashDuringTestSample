package com.nitro.data.rest

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * Created by t.coulange on 24/07/2020.
 */
@Module
@InstallIn(ApplicationComponent::class)
abstract class RestModule {
    @Binds
    abstract fun provideRestApi(realUserApi: RealUserApi): UserApi
}