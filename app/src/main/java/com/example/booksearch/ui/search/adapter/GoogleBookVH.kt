package com.example.booksearch.ui.search.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.R
import com.example.booksearch.databinding.VBooksListItemBinding
import com.example.booksearch.utils.loadImage

class GoogleBookVH(private val binding: VBooksListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(bookItem: GoogleBookItem) {
        with(binding) {
            vBooksListItemAuthors.text = bookItem.volumeInfo?.authors?.first()
            vBooksListItemTitle.text = bookItem.volumeInfo?.title
            bookItem.volumeInfo?.imageLinks?.smallThumbnail?.let { vBooksListItemCover.loadImage(it, R.drawable.image_placeholder, binding.vBooksListItemCover) }
        }
    }
}
