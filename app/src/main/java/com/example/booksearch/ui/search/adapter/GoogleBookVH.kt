package com.example.booksearch.ui.search.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.databinding.VBooksListItemBinding
import com.example.booksearch.domain.models.BookItemResponse
import com.example.booksearch.utils.loadImage

class GoogleBookVH(private val binding: VBooksListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(bookItem: GoogleBookItem) {
        with(binding) {
            vBooksListItemAuthors.text = bookItem.volumeInfo?.authors.toString()
            vBooksListItemTitle.text = bookItem.volumeInfo?.title.toString()
            vBooksListItemCover.loadImage(bookItem)
        }
    }
}
