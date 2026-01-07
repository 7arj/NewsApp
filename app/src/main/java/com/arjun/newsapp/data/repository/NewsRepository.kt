package com.arjun.newsapp.data.repository

import android.util.Log
import com.arjun.newsapp.BuildConfig
import com.arjun.newsapp.data.remote.RetrofitInstance

class NewsRepository {

    suspend fun fetchNews() =
        RetrofitInstance.api.getTopHeadlines(
            apiKey = BuildConfig.GNEWS_API_KEY
        ).also {
            Log.d("NewsRepository", "Response code = ${it.code()}")
        }
}
