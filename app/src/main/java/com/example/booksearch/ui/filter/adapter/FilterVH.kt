package com.example.booksearch.ui.filter.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.databinding.VFilterListItemBinding

class FilterVH(private val binding: VFilterListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

     val isCheckedButton = binding.filtersListItemImageViewSelected
    fun bind(
        filterItem: FilterItem,
        isSelect: Boolean,
        onFilterClick: () -> Unit
    ) {
        with(binding) {
            filtersListItemTextViewFilterTitle.setText(filterItem.title)
            filtersListItemImageViewSelected.visibility =
                if (isSelect) View.VISIBLE else View.INVISIBLE
            layoutRoot.setOnClickListener {
                onFilterClick.invoke()
            }
        }
    }

}
