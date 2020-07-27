package com.nitro.crashduringtestsample.test

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.nitro.crashduringtestsample.MainActivity
import com.nitro.crashduringtestsample.Data
import com.nitro.crashduringtestsample.FakeApi
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Test

/**
 * Created by nitro on 24/07/2020.
 */

class MainActivityTest {
    private fun test() {
        /**
         * Without a mockk object with a coEvery call no instrumentation runner crash
         */
        val notUsedApi: FakeApi = mockk()
        //Need the coevery, and to return an object, with a boolean no crash
        coEvery { notUsedApi.getData() } returns Data()

        ActivityScenario.launch<MainActivity>(MainActivity::class.java)
        Espresso.onView(ViewMatchers.withText("Hello world")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testMockApi() {
        test()
    }

    @Test
    fun testMockApi2() {
        test()
    }

    @Test
    fun testMockApi3() {
        test()
    }

    @Test
    fun testMockApi4() {
        test()
    }

    @Test
    fun testMockApi5() {
        test()
    }

    //Without at least 6 tests here no crash, seems to depends on the binary size of the app/test app ?!
    @Test
    fun testMockApi6() {
        test()
    }
}