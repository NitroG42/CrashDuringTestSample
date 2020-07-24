package com.nitro.crashduringtestsample

import androidx.multidex.MultiDexApplication

/**
 * Created by t.coulange on 08/07/2020.
 */
open class TestApplicationImpl : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
    }
}