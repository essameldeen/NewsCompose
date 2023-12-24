package com.example.newscompose.ui.repository

import com.example.newscompose.data.entity.NewsResponse
import retrofit2.Response

interface NewsRepository {
    suspend fun getTopNewsHeadline(country: String): Response<NewsResponse>
}