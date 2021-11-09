package com.example.booksearch.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun ImageView.loadImage(url: String?, placeHolder: Drawable?) {
  Glide.with(this.context)
      .load(url)
      .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
      .transition(DrawableTransitionOptions.withCrossFade())
      .placeholder(placeHolder)
      .centerCrop()
      .into(this)

}
