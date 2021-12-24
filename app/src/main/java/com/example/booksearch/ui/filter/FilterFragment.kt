package com.example.booksearch.ui.filter

import com.example.booksearch.databinding.FFiltersBinding
import com.example.booksearch.ui.base.BaseFragment
import com.example.booksearch.ui.filter.adapter.FilterAdapter
import com.example.booksearch.ui.filter.adapter.FilterItem
import moxy.presenter.InjectPresenter

class FilterFragment : BaseFragment<FFiltersBinding>(FFiltersBinding::inflate), FilterView {

    @InjectPresenter
    lateinit var presenter: FilterPresenter
    private val filtersAdapter by lazy {
        FilterAdapter(
            { filterList: List<FilterItem> -> setFilters(filterList) },
            object : FilterAdapter.OnFilterClickListener {
                override fun onFilterClick(param: FilterItem) {
                    presenter.onFilterClick(param)
                }
            },
        )
    }

    override fun initViews() {
        binding.filtersRecyclerView.adapter = filtersAdapter
        initBackToSearchListener()
    }

    override fun setFilters(filterList: List<FilterItem>) {
        filtersAdapter.setItems(filterList)
    }

    override fun updateFiltersList(updatedList: List<FilterItem>) {
        filtersAdapter.setItems(updatedList)
        binding.filtersRecyclerView.adapter = filtersAdapter
    }

    private fun initBackToSearchListener() {
        binding.toolbarFilters.filtersBackToSearchBtn.setOnClickListener { presenter.onBackClick() }
    }
}
