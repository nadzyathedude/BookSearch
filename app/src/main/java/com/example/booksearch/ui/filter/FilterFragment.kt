package com.example.booksearch.ui.filter

import android.view.*
import com.example.booksearch.databinding.FFiltersBinding
import com.example.booksearch.databinding.VFilterListItemBinding
import com.example.booksearch.ui.base.BaseFragment
import com.example.booksearch.ui.filter.adapter.FilterAdapter
import com.example.booksearch.ui.filter.adapter.FilterItem
import moxy.presenter.InjectPresenter
import java.util.logging.Filter

class FilterFragment : BaseFragment<FFiltersBinding>(FFiltersBinding::inflate), FilterView {

    @InjectPresenter
    lateinit var presenter: FilterPresenter
    private val filtersAdapter by lazy { FilterAdapter() }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun initListener() {
        VFilterListItemBinding.bind(binding.root).filtersListItemTextViewFilterTitle.setOnClickListener {
            presenter.getChosenFilterPosition()
        }
    }

    override fun initViews() {
        setHasOptionsMenu(true)
        binding.filtersRecyclerView.adapter = filtersAdapter
        initListener()
    }

    override fun setFilters(filterList: List<FilterItem>) {
        filtersAdapter.setItems(filterList)
    }
}
