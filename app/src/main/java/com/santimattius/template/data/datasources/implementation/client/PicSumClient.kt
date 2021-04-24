package com.santimattius.template.data.datasources.implementation.client

import com.santimattius.template.core.Result
import com.santimattius.template.data.models.NetworkPicture
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PicSumClient(baseUrl: String) {

    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    private val service: PicSumService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .run { create(PicSumService::class.java) }


    suspend fun fetchList(): Result<List<NetworkPicture>> = try {
        Result.success(service.fetchList())
    } catch (exception: Throwable) {
        Result.failure(exception)
    }
}