package com.oguzhanozgokce.musicsplayer.data.remote

import com.oguzhanozgokce.musicsplayer.data.model.SongData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun getSongData(
        @Query("q") query: String,
        @Header("X-RapidAPI-Key") apiKey: String = "5bdfcb97cbmsheda8fec2d9783b1p136971jsn6cbf2bd2bd9c",
        @Header("X-RapidAPI-Host") apiHost: String = "deezerdevs-deezer.p.rapidapi.com"
    ): List<SongData>



}