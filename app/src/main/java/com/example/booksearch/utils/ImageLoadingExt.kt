package com.example.booksearch.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.booksearch.R

fun ImageView.loadImage(imgUrl: String, placeholder: Int, image: ImageView) {

    // val imgUrl = item.volumeInfo?.imageLinks?.smallThumbnail
    Glide.with(context)
        .load(imgUrl)
        .placeholder(placeholder)
        .centerCrop()
        .into(findViewById(R.id.v_books_list_item_cover))
}
