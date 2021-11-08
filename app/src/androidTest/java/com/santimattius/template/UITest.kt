package com.santimattius.template

import androidx.test.espresso.IdlingRegistry
import com.santimattius.template.core.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.koin.core.context.GlobalContext
import org.koin.core.module.Module
import org.koin.test.KoinTest

abstract class UITest : KoinTest {
    @Before
    fun setup() {
        GlobalContext.loadKoinModules(dependencies)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
        GlobalContext.unloadKoinModules(dependencies)
    }

    abstract val dependencies: Module
}