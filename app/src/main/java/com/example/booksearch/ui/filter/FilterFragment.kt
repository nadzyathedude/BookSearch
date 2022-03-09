package com.example.booksearch.ui.filter

import android.os.Bundle
import com.example.booksearch.databinding.FFiltersBinding
import com.example.booksearch.ui.base.BaseFragment
import com.example.booksearch.ui.filter.adapter.FilterAdapter
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.filter.adapter.FilterItem
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import java.lang.IllegalArgumentException

const val ARGS_KEY = "FilterParameter.args"

class FilterFragment : BaseFragment<FFiltersBinding>(FFiltersBinding::inflate), FilterView {

    companion object {

        fun newInstance(filterParameter: FilterEnum): FilterFragment {
            val args = Bundle()
            args.putSerializable(ARGS_KEY, filterParameter)
            return FilterFragment().apply {
                arguments = args
            }
        }
    }

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

    @ProvidePresenter
    fun providePresenter(): FilterPresenter {
        val data = requireArguments().getSerializable(ARGS_KEY) as? FilterEnum
            ?: throw IllegalArgumentException("argument key for filter parameter invalid")
        return FilterPresenter(data)
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
        binding.toolbarFilters.setNavigationOnClickListener { presenter.onBackClick() }
    }
}
