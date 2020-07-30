package com.manwinder.redditnews.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.manwinder.redditnews.R
import com.manwinder.redditnews.ui.adapter.RedditNewsAdapter
import com.manwinder.redditnews.util.createSnackbar
import com.manwinder.redditnews.viewmodels.RedditNewsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import com.manwinder.redditnews.data.RedditResponseData.Data.Children.Data as RedditData

class MainActivity : AppCompatActivity() {

    private val redditNewsViewModel by lazy { RedditNewsViewModel() }

    private val openArticle = fun(data: RedditData) {
        val intent = Intent(this, ArticleActivity::class.java)
        intent.putExtra(getString(R.string.article_data), data)
        startActivity(intent)
    }

    private val redditNewsAdapter = RedditNewsAdapter(openArticle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reddit_news_feed_recycler_view?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = redditNewsAdapter
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }

        redditNewsViewModel.redditNewsLiveData.observe(this, Observer {
            redditNewsAdapter.updateArticles(it)
        })

        redditNewsViewModel.networkErrorCodeLiveData.observe(this, Observer {
            reddit_news_feed_recycler_view?.createSnackbar(getString(R.string.network_error))
        })

        redditNewsViewModel.fetchNews()
    }
}
