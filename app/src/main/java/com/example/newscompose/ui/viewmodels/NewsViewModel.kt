package com.example.newscompose.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newscompose.data.AppConstants.COUNTRY
import com.example.newscompose.data.entity.NewsResponse
import com.example.newscompose.ui.repository.NewsRepository
import com.example.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _state: MutableStateFlow<ResourceState<NewsResponse>> =
        MutableStateFlow(ResourceState.Loading())

    val state: StateFlow<ResourceState<NewsResponse>> = _state

    init {
        getNews(COUNTRY)
    }

    fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadline(country)
                .collectLatest { newResponse ->
                    _state.value = newResponse
                }
        }
    }

    companion object {
        const val TAG = "NewsViewModel"
    }
}