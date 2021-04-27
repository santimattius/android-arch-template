package com.santimattius.template.presentation.models

data class PictureUiModel(
    val id: String,
    val author: String,
    val url: String,
    val height: Int,
    val width: Int,
) : UiItem(id)