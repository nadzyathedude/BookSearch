package com.example.booksearch.ui.filter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.databinding.VFilterListItemBinding

class FilterAdapter(
    private val setFilterList: (List<FilterItem>) -> Unit,
    private val listener: OnFilterClickListener,
    selectedPosition: Int? = null
) : RecyclerView.Adapter<FilterVH>() {

    init {
        selectedPosition?.let { pos ->
            selectedItemPosition = pos
        }
    }

    private var filterList = mutableListOf<FilterItem>()
    private var selectedItemPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterVH {
        return FilterVH(
            VFilterListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FilterVH, position: Int) {
        holder.bind(
            filterList[position],
            position
        ) { _, _ -> listener.onFilterClick(filterList[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = filterList.size

    fun setItems(newItems: List<FilterItem>) {
        if (newItems == filterList) return
        filterList.clear()
        filterList.addAll(newItems)
        notifyDataSetChanged()
    }

    interface OnFilterClickListener {

        fun onFilterClick(param: FilterItem)
    }
}
