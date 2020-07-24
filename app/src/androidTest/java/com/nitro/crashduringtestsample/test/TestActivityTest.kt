package com.nitro.crashduringtestsample.test

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.nitro.crashduringtestsample.TestActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

/**
 * Created by t.coulange on 24/07/2020.
 */
@HiltAndroidTest
class TestActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun test() {
        ActivityScenario.launch<TestActivity>(TestActivity::class.java)
        Espresso.onView(withText("Test"))
            .perform(ViewActions.click())
    }

    @Test
    fun test2() {
        ActivityScenario.launch<TestActivity>(TestActivity::class.java)
        Espresso.onView(withText("Test"))
            .perform(ViewActions.click())
    }

    @Test
    fun test3() {
        ActivityScenario.launch<TestActivity>(TestActivity::class.java)
        Espresso.onView(withText("Test"))
            .perform(ViewActions.click())
    }

    @Test
    fun test4() {
        ActivityScenario.launch<TestActivity>(TestActivity::class.java)
        Espresso.onView(withText("Test"))
            .perform(ViewActions.click())
    }
}