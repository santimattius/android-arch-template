package com.santimattius.template

import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.santimattius.template.core.EspressoIdlingResource
import io.mockk.MockKAnnotations
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.test.KoinTest

@LargeTest
@RunWith(AndroidJUnit4::class)
abstract class UITest : KoinTest {

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        loadKoinModules(dependencies)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
        unloadKoinModules(dependencies)
    }

    abstract val dependencies: Module
}