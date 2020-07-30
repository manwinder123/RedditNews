package com.manwinder.redditnews.ui.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.manwinder.redditnews.R
import com.manwinder.redditnews.util.loadImage
import kotlinx.android.synthetic.main.activity_article.*
import com.manwinder.redditnews.data.RedditResponseData.Data.Children.Data as RedditData

class ArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val articleData: RedditData? = intent.getParcelableExtra(getString(R.string.article_data))

        supportActionBar?.title = articleData?.title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        article_image_view.loadImage(articleData?.url)

        article_web_view?.settings?.javaScriptEnabled = true
        article_web_view?.loadUrl(articleData?.url)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
