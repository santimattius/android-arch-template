package com.santimattius.template.data.datasources.implementation

import com.santimattius.template.core.Failure
import com.santimattius.template.core.Success
import com.santimattius.template.data.datasources.RemoteDataSource
import com.santimattius.template.data.datasources.implementation.client.PicSumClient

internal class ServiceDataSource(private val client: PicSumClient) : RemoteDataSource {

    override suspend fun getPictures() = when (val result = client.fetchList()) {
        is Success -> result.out
        is Failure -> emptyList()
    }

}