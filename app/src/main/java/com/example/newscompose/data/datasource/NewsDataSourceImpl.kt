package com.example.newscompose.data.datasource

import com.example.newscompose.data.api.NewsService
import com.example.newscompose.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val api: NewsService
) : NewsDatasource {
    override suspend fun getTopNewsHeadline(country: String): Response<NewsResponse> {
        return api.getTopNewsHeadline(country)
    }
}