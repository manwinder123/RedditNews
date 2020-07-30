package com.manwinder.redditnews.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.manwinder.redditnews.data.RedditResponseData
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RedditApi {

    @GET("r/kotlin/.json")
    fun getPosts(): Deferred<Response<RedditResponseData>>

    companion object Factory {
        private const val BASE_URL = "https://www.reddit.com/"

        fun getApi(): RedditApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }).build())
                .build()
                .create(RedditApi::class.java)
        }
    }
}