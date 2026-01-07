package com.arjun.newsapp.data.remote

import com.arjun.newsapp.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/v4/top-headlines")
    suspend fun getTopHeadlines(
        @Query("token") apiKey: String,
        @Query("lang") lang: String = "en",
        @Query("country") country: String = "us"
    ): Response<NewsResponse>
}
