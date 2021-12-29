package com.example.booksearch.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.booksearch.R
import com.example.booksearch.ui.search.adapter.GoogleBookItem

fun ImageView.loadImage(item: GoogleBookItem) {

    val imgUrl = item.volumeInfo?.imageLinks?.smallThumbnail
    Glide.with(context)
        .load(imgUrl)
        .placeholder(R.drawable.image_placeholder)
        .centerCrop()
        .into(findViewById(R.id.v_books_list_item_cover))
}
