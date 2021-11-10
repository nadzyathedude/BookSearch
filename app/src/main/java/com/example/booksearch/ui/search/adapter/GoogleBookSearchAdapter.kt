package com.example.booksearch.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.databinding.VBooksListItemBinding

class GoogleBookSearchAdapter : RecyclerView.Adapter<GoogleBookVH>() {

    private var booksList = mutableListOf<GoogleBookItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoogleBookVH {
        return GoogleBookVH(
            VBooksListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GoogleBookVH, position: Int) {
        holder.bind(booksList[position])
    }

    override fun getItemCount() = booksList.size
}