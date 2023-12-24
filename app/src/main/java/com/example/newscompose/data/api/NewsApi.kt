package com.example.newscompose.data.api

import com.example.newscompose.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("v2/top-headlines")
    fun getTopNewsHeadline(
        @Query("country") country: String,
        @Query("apikey") apiKey: String = "13530e0d940a4aceb51f4bf1134e1736"
    ): Response<NewsResponse>
}