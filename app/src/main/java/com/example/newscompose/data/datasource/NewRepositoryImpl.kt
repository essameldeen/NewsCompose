package com.example.newscompose.data.datasource

import com.example.newscompose.data.api.NewsService
import com.example.newscompose.data.entity.NewsResponse
import com.example.newscompose.ui.repository.NewsRepository
import retrofit2.Response
import javax.inject.Inject

class NewRepositoryImpl @Inject constructor(
    private val api: NewsService
) : NewsRepository {
    override suspend fun getTopNewsHeadline(country: String): Response<NewsResponse> {
        return api.getTopNewsHeadline(country)
    }
}