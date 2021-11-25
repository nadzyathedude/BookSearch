package com.example.booksearch.ui.search.adapter

import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.R
import com.example.booksearch.databinding.VBooksListItemBinding
import com.example.booksearch.utils.loadImage

class GoogleBookVH(private val binding: VBooksListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

  fun bind(bookItem: GoogleBookItem) {
    with(binding) {
      vBooksListItemAuthors.text = bookItem.authors
      vBooksListItemTitle.text = bookItem.title
      vBooksListItemCover.loadImage(
          bookItem.imageUrl,
          AppCompatResources.getDrawable(binding.root.context, R.drawable.image_placeholder))
    }
  }
}
