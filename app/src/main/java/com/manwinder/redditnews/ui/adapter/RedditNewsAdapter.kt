package com.manwinder.redditnews.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.manwinder.redditnews.R
import com.manwinder.redditnews.util.createSnackbar
import com.manwinder.redditnews.util.loadImage
import kotlinx.android.synthetic.main.row_article.view.*
import com.manwinder.redditnews.data.RedditResponseData.Data.Children.Data as RedditData

class RedditNewsAdapter(val openArticle: (RedditData) -> Unit): RecyclerView.Adapter<RedditNewsAdapter.ArticleRowViewHolder>() {

    private val articles: MutableList<RedditData> = mutableListOf()

    fun updateArticles(articles: List<RedditData>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleRowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_article, parent, false)
        return ArticleRowViewHolder(view)
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ArticleRowViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    inner class ArticleRowViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun bind(data: RedditData) {
            view.article_title.text = data.title

            view.article_image_view.loadImage(data.url)

            data.url ?: run {
                view.setOnClickListener {
                    view.createSnackbar(view.context.getString(R.string.article_does_not_exist))
                }
                return
            }

            view.setOnClickListener {
                openArticle(data)
            }
        }
    }
}
