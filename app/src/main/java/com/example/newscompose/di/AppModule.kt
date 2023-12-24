package com.example.newscompose.di

import com.example.newscompose.data.AppConstants
import com.example.newscompose.data.api.NewsService
import com.example.newscompose.data.datasource.NewsDataSourceImpl
import com.example.newscompose.data.datasource.NewsDatasource
import com.example.newscompose.ui.repository.NewsRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
            readTimeout(60, TimeUnit.SECONDS)
        }
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideNewApiService(retrofit: Retrofit): NewsService {
        return retrofit.create(NewsService::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsDataSource(newsService: NewsService): NewsDatasource {
        return NewsDataSourceImpl(newsService)
    }

    @Provides
    @Singleton
    fun provideNewRepository(datasource: NewsDatasource): NewsRepository {
        return NewsRepository(datasource)
    }
}