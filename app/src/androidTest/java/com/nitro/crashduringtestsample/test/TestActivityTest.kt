package com.nitro.crashduringtestsample.test

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.nitro.crashduringtestsample.TestActivity
import org.junit.Test

/**
 * Created by nitro on 24/07/2020.
 * Without another activity to test, no crash
 */
class TestActivityTest {
    private fun test() {
        ActivityScenario.launch<TestActivity>(TestActivity::class.java)
        Espresso.onView(withText("Test"))
            .perform(ViewActions.click())
    }

    @Test
    fun test1() {
        test()
    }

    @Test
    fun test2() {
        test()
    }

    @Test
    fun test3() {
        test()
    }

    @Test
    fun test4() {
        test()
    }

    //Without at least 5 tests here no crash, seems to depends on the binary size of the app/test app ?!
    @Test
    fun test5() {
        test()
    }
}