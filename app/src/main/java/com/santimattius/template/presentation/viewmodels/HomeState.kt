package com.santimattius.template.presentation.viewmodels

import com.santimattius.template.presentation.models.PictureUiModel

sealed class HomeState

object Loading : HomeState()

data class Data(val values: List<PictureUiModel>) : HomeState()

object Error : HomeState()