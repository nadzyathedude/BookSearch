package com.example.booksearch.ui.filter.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.databinding.VFilterListItemBinding

class FilterVH(private val binding: VFilterListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        filterItem: FilterItem,
        position: Int,
        onFilterClick: ((FilterItem, Int) -> Unit)
    ) {
        with(binding) {
            filtersListItemTextViewFilterTitle.setText(filterItem.title)
            filtersListItemImageViewSelected.isVisible = filterItem.isSelected
            layoutRoot.setOnClickListener {
                onFilterClick.invoke(filterItem, position)
            }
        }
    }
}
