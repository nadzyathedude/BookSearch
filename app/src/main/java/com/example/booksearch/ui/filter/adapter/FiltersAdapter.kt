package com.example.booksearch.ui.filter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.databinding.VFilterListItemBinding
import com.example.booksearch.ui.filter.FilterFragment

class FilterAdapter(
    private val setFilterList: (List<FilterItem>) -> Unit,
    private val onFilterClick: (List<FilterItem>) -> Unit
) : RecyclerView.Adapter<FilterVH>() {

    private var filterList = mutableListOf<FilterItem>()
    private var selectedItemPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterVH {
        return FilterVH(
            VFilterListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FilterVH, position: Int) {
        holder.bind(filterList[position], selectedItemPosition == position) {
            if (selectedItemPosition == -1 || selectedItemPosition == holder.adapterPosition) return@bind

            val lastSelectedPosition = selectedItemPosition
            selectedItemPosition = holder.adapterPosition
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedItemPosition)
        }
    }

    override fun getItemCount(): Int = filterList.size

    fun setItems(newItems: List<FilterItem>) {
        filterList.addAll(newItems)
        notifyDataSetChanged()
    }

}
