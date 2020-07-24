package com.nitro.crashduringtestsample

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withText
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

/**
 * Created by t.coulange on 24/07/2020.
 */
@HiltAndroidTest
class TestTestActivity {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val intentsTestRule = IntentsTestRule(TestActivity::class.java)


    @Test
    fun test() {
        val activity =
            ActivityScenario.launch<TestActivity>(TestActivity::class.java).onActivity { activity ->

            }
        Espresso.onView(withText("Test"))
            .perform(ViewActions.click())
    }

    @Test
    fun test2() {
        val activity =
            ActivityScenario.launch<TestActivity>(TestActivity::class.java).onActivity { activity ->

            }
        Espresso.onView(withText("Test"))
            .perform(ViewActions.click())
    }

    @Test
    fun test3() {
        val activity =
            ActivityScenario.launch<TestActivity>(TestActivity::class.java).onActivity { activity ->

            }
        Espresso.onView(withText("Test"))
            .perform(ViewActions.click())
    }

    @Test
    fun test4() {
        val activity =
            ActivityScenario.launch<TestActivity>(TestActivity::class.java).onActivity { activity ->

            }
        Espresso.onView(withText("Test"))
            .perform(ViewActions.click())
    }
}