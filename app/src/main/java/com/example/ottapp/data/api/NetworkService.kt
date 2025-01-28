package com.example.ottapp.data.api

import com.example.ottapp.data.model.MainAnimeRes
import retrofit2.http.GET

interface NetworkService {

    @GET("top/anime")
    suspend fun getAnimeList(): MainAnimeRes
}