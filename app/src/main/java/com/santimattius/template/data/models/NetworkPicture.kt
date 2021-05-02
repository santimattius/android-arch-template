package com.santimattius.template.data.models

import com.santimattius.template.domain.entities.Picture
import com.squareup.moshi.Json

data class NetworkPicture(
    @Json(name = "author") override val author: String = "",
    @Json(name = "width") override val width: Int = 0,
    @Json(name = "download_url") override val downloadUrl: String = "",
    @Json(name = "id") override val id: String = "",
    @Json(name = "url") override val url: String = "",
    @Json(name = "height") override val height: Int = 0
) : Picture