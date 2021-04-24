package com.santimattius.template.presentation.models

sealed class HomeState

object Loading : HomeState()

data class Data(val value: List<PictureUiModel>) : HomeState()