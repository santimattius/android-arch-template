package com.santimattius.template.core

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val okHttpClient = HttpLoggingInterceptor().run {
    level = HttpLoggingInterceptor.Level.BODY
    OkHttpClient.Builder().addInterceptor(this).build()
}

internal inline fun <reified S> service(baseUrl: String): S = create(baseUrl = baseUrl)
    .run { create(S::class.java) }

private fun create(baseUrl: String) = Retrofit.Builder()
    .baseUrl(baseUrl)
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()