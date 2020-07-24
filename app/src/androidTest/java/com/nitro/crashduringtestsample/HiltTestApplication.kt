package com.nitro.crashduringtestsample

import com.nitro.crashduringtestsample.TestApplicationImpl
import dagger.hilt.android.testing.CustomTestApplication

/**
 * Created by t.coulange on 08/07/2020.
 */


@CustomTestApplication(TestApplicationImpl::class)
interface HiltTestApplication
