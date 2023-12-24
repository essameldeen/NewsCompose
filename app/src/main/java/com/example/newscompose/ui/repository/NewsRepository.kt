package com.example.newscompose.ui.repository

import com.example.newscompose.data.datasource.NewsDatasource
import com.example.newscompose.data.entity.NewsResponse
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val datasource: NewsDatasource
) {

    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())
            val response = datasource.getTopNewsHeadline(country)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error Fetching News Data!"))
            }

        }.catch { e -> emit(ResourceState.Error(e.localizedMessage ?: "Some Error in flow")) }
    }
}