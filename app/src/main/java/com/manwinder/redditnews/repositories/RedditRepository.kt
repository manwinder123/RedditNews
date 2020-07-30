package com.manwinder.redditnews.repositories

import androidx.lifecycle.MutableLiveData
import com.manwinder.redditnews.api.RedditApi
import com.manwinder.redditnews.data.RedditResponseData
import java.io.IOException

class RedditRepository() {

    private val service = RedditApi.getApi()

    val redditNewsFeedLiveData: MutableLiveData<List<RedditResponseData.Data.Children.Data>> = MutableLiveData()

    val networkErrorCodeLiveData: MutableLiveData<Int> = MutableLiveData()

    suspend fun getNews() {
        val request = service.getPosts()
        try {
            val response = request.await()
            if (response.isSuccessful) {
                val listOfArticles = response.body()?.data?.children?.mapNotNull { it?.data }

                redditNewsFeedLiveData.postValue(listOfArticles)
            } else {
                networkErrorCodeLiveData.postValue(response.code())
            }
        } catch (e: IOException) {
            networkErrorCodeLiveData.postValue(0)
        }
    }
}