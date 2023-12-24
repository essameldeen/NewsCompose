package com.example.newscompose.data.datasource

import com.example.newscompose.data.entity.NewsResponse
import retrofit2.Response

interface NewsDatasource {
    suspend fun getTopNewsHeadline(country: String): Response<NewsResponse>

}