package com.manwinder.redditnews.util

import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

fun ImageView.loadImage(imageUrl: String?) {
    imageUrl ?: return

    Glide.with(this.context)
        .load(imageUrl)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(p0: GlideException?, p1: Any?, p2: com.bumptech.glide.request.target.Target<Drawable>?, p3: Boolean): Boolean {
                this@loadImage.visibility = View.GONE
                return false
            }

            override fun onResourceReady(p0: Drawable?, p1: Any?, p2: com.bumptech.glide.request.target.Target<Drawable>?, p3: DataSource?, p4: Boolean): Boolean {
                this@loadImage.visibility = View.VISIBLE
                return false
            }
        })
        .into(this)
}

fun View.createSnackbar(text: String) {
    val snackbar: Snackbar = Snackbar.make(this, text, Snackbar.LENGTH_SHORT)
    snackbar.show()
}
