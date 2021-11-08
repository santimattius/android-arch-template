package com.santimattius.template

import androidx.test.espresso.IdlingRegistry
import com.santimattius.template.core.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.test.KoinTest

abstract class UITest : KoinTest {

    @Before
    open fun setup() {
        loadKoinModules(dependencies)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    open fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
        unloadKoinModules(dependencies)
    }

    abstract val dependencies: Module
}