package com.example.ottapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ottapp.data.model.Data
import com.example.ottapp.data.repository.AnimeListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class AnimeListViewModel(private val animeListRepository: AnimeListRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Data>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<Data>>> = _uiState


    init {
        fetchData()
    }


    private fun fetchData() {
        viewModelScope.launch {
            animeListRepository.getAnimeList()
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }

}