package com.santimattius.template.data.datasources.implementation.client

import com.santimattius.template.data.models.NetworkPicture
import retrofit2.http.GET

interface PicSumService {

    @GET("/v2/list")
    suspend fun fetchList(): List<NetworkPicture>
}