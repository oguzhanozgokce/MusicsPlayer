package com.oguzhanozgokce.musicsplayer.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://deezerdevs-deezer.p.rapidapi.com/"

    // OkHttpClient oluştur ve Interceptor'ı ekle
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-RapidAPI-Key", "5bdfcb97cbmsheda8fec2d9783b1p136971jsn6cbf2bd2bd9c")
                .addHeader("X-RapidAPI-Host", "deezerdevs-deezer.p.rapidapi.com")
                .build()
            chain.proceed(request)
        }
        .build()

    // Retrofit nesnesini oluştur
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient) // OkHttpClient'i Retrofit'e ekle
            .build()
    }
}

