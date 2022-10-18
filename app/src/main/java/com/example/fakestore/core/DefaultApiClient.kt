package com.example.fakestore.core

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object DefaultApiClient {

    private const val BASE_URL = "https://fakestoreapi.com/"

    private fun buildOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder().client(buildOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Volatile
    private var INSTANCE: Retrofit? = null

    fun init() {
        INSTANCE = buildRetrofit()
    }

    @Synchronized
    fun getInstance(): Retrofit {
        return synchronized(this) {
            INSTANCE
                ?: throw IllegalArgumentException("You need to initialize ApiClient first in the application class")
        }
    }
}