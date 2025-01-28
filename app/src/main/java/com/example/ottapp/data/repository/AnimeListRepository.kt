package com.example.ottapp.data.repository

import com.example.ottapp.data.api.NetworkService
import com.example.ottapp.data.model.Data
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AnimeListRepository @Inject constructor(private val networkService: NetworkService) {

    fun getAnimeList(): Flow<List<Data>> {
        return flow {
            emit(networkService.getAnimeList())
        }.map {
            it.data
        }
    }
}