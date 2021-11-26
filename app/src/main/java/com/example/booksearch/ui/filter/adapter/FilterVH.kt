package com.example.booksearch.ui.filter.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.databinding.VFilterListItemBinding

class FilterVH(private val binding: VFilterListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(filterItem: FilterItem, isSelect: Boolean, listener: () -> Unit) {
        binding.filtersListItemTextViewFilterTitle.text = filterItem.title
        binding.filtersListItemImageViewSelected.visibility =
            if (isSelect) View.VISIBLE else View.INVISIBLE
        binding.layoutRoot.setOnClickListener { listener.invoke() }
    }
}
