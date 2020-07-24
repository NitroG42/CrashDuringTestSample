package com.nitro.crashduringtestsample

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.nitro.data.db.DbModule
import com.nitro.data.db.MyDatabase
import com.nitro.data.rest.RestModule
import com.nitro.data.rest.UserApi
import com.nitro.data.vo.User
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Singleton

/**
 * Created by t.coulange on 24/07/2020.
 */
@HiltAndroidTest
@UninstallModules(DbModule::class, RestModule::class)
class MainActivityTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @BindValue
    @RelaxedMockK
    lateinit var api: UserApi

//            = object : UserApi {
//        override suspend fun getUser(): User {
//            return User("mock", "Mock User")
//        }
//    }

    @Module
    @InstallIn(ApplicationComponent::class)
    object TestModule {
        @Provides
        @Singleton
        fun inMemoryDb(@ApplicationContext context: Context): MyDatabase =
            Room.inMemoryDatabaseBuilder(context, MyDatabase::class.java).build()
    }


    @Before
    fun init() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        hiltRule.inject()
    }


    @Test
    fun testMockApi() {
        val expectedName = "Mock User"
        coEvery { api.getUser() } returns User("mock", expectedName)
        ActivityScenario.launch<MainActivity>(MainActivity::class.java)
        Espresso.onView(ViewMatchers.withText(expectedName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testMockApi2() {
        val expectedName = "Mock User"
        coEvery { api.getUser() } returns User("mock", expectedName)
        ActivityScenario.launch<MainActivity>(MainActivity::class.java)
        Espresso.onView(ViewMatchers.withText(expectedName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testMockApi3() {
        val expectedName = "Mock User"
        coEvery { api.getUser() } returns User("mock", expectedName)
        ActivityScenario.launch<MainActivity>(MainActivity::class.java)
        Espresso.onView(ViewMatchers.withText(expectedName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testMockApi4() {
        val expectedName = "Mock User"
        coEvery { api.getUser() } returns User("mock", expectedName)
        ActivityScenario.launch<MainActivity>(MainActivity::class.java)
        Espresso.onView(ViewMatchers.withText(expectedName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}