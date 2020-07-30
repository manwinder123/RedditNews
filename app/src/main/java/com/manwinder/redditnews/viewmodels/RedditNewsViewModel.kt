package com.manwinder.redditnews.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manwinder.redditnews.repositories.RedditRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RedditNewsViewModel: ViewModel() {
    val redditRepository = RedditRepository()

    val redditNewsLiveData = redditRepository.redditNewsFeedLiveData

    val networkErrorCodeLiveData = redditRepository.networkErrorCodeLiveData

    fun fetchNews() {
        viewModelScope.launch(Dispatchers.IO) {
            redditRepository.getNews()
        }
    }
}