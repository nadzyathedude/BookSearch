package com.example.booksearch.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
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

    fun setItems(newItems: List<GoogleBookItem>) {
        val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = booksList.size
            override fun getNewListSize(): Int = newItems.size
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                booksList[oldItemPosition] == newItems[newItemPosition]

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                booksList[oldItemPosition] == newItems[newItemPosition]
        })
        booksList = newItems.toMutableList()
        result.dispatchUpdatesTo(this)
    }
}