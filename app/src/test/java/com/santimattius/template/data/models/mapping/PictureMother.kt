package com.santimattius.template.data.models.mapping

import com.santimattius.template.domain.entities.Picture
import com.santimattius.template.utils.UnitTestUtils

object PictureMother {

    fun create(id: Long = 1234) = FakePicture(
        id = "$id",
        author = UnitTestUtils.randomString(),
        width = UnitTestUtils.randomInt(),
        height = UnitTestUtils.randomInt(),
        url = UnitTestUtils.randomString(),
        downloadUrl = UnitTestUtils.randomString()
    )

    fun generate(size: Int = 10) = (1..size).map { create(id = it.toLong()) }
}

data class FakePicture(
    override val author: String,
    override val width: Int,
    override val downloadUrl: String,
    override val id: String,
    override val url: String,
    override val height: Int
) : Picture