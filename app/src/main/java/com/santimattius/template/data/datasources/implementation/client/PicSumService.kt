package com.santimattius.template.data.datasources.implementation.client

import com.santimattius.template.data.models.NetworkPicture
import retrofit2.http.GET
import retrofit2.http.Path

interface PicSumService {

    @GET("/v{version}/list")
    suspend fun fetchList(@Path("version") version: Int = 2): List<NetworkPicture>
}