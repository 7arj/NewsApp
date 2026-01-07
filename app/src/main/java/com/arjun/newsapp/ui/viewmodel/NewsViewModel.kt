package com.arjun.newsapp.ui.viewmodel

import androidx.lifecycle.*
import com.arjun.newsapp.data.model.Article
import com.arjun.newsapp.data.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repository = NewsRepository()

    private val _news = MutableLiveData<List<Article>>()
    val news: LiveData<List<Article>> = _news

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun fetchNews() {
        _isLoading.value = true
        _errorMessage.value = null

        viewModelScope.launch {
            try {
                val response = repository.fetchNews()

                if (response.isSuccessful) {
                    _news.value = response.body()?.articles ?: emptyList()
                } else {
                    _errorMessage.value = "Failed to load news (${response.code()})"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Network error. Please try again."
            } finally {
                _isLoading.value = false
            }
        }
    }
}
