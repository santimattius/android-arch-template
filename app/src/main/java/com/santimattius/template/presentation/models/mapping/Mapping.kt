package com.santimattius.template.presentation.models.mapping

import com.santimattius.template.domain.entities.Picture
import com.santimattius.template.presentation.models.PictureUiModel


internal fun List<Picture>.asUiModels() = map { it.asUiModel() }

internal fun Picture.asUiModel() =
    PictureUiModel(
        id = id,
        author = author,
        url = downloadUrl,
        height = height,
        width = width
    )