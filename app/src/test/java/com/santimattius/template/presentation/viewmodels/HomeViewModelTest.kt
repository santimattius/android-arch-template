package com.santimattius.template.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.santimattius.template.domain.usecases.GetPictures
import com.santimattius.template.presentation.models.Data
import com.santimattius.template.presentation.models.Error
import com.santimattius.template.utils.CoroutinesTestRule
import com.santimattius.template.utils.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class HomeViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @ExperimentalCoroutinesApi
    @Test
    fun `check case when init view model`() = runBlockingTest {

        val userCase = mockk<GetPictures>()

        coEvery { userCase() } returns emptyList()

        val viewModel = HomeViewModel(userCase)

        assertThat(viewModel.state.getOrAwaitValue(), IsEqual(Data(emptyList())))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `check when init fail with exception`() = runBlockingTest {

        val userCase = mockk<GetPictures>()

        coEvery { userCase() } throws Exception()

        val viewModel = HomeViewModel(userCase)

        assertThat(viewModel.state.getOrAwaitValue(), IsEqual(Error))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `check case with retry`() = runBlockingTest {

        val userCase = mockk<GetPictures>()

        coEvery { userCase() } returns emptyList()

        val viewModel = HomeViewModel(userCase)

        viewModel.retry()

        assertThat(viewModel.state.getOrAwaitValue(), IsEqual(Data(emptyList())))
    }

}