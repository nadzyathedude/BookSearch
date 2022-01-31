package com.example.booksearch.ui.search

import android.view.* // ktlint-disable no-wildcard-imports
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.R
import com.example.booksearch.databinding.FSearchBinding
import com.example.booksearch.domain.interactor.FilterInteractor
import com.example.booksearch.ui.MainActivity
import com.example.booksearch.ui.base.BaseFragment
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import com.example.booksearch.ui.search.adapter.GoogleBookSearchAdapter
import com.example.booksearch.utils.safeLet
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject

class SearchFragment :
    BaseFragment<FSearchBinding>(FSearchBinding::inflate),
    com.example.booksearch.ui.search.SearchView {

    @InjectPresenter
    lateinit var searchPresenter: SearchPresenter
    private val interactor: FilterInteractor by inject()
    private val googleBookSearchAdapter by lazy { GoogleBookSearchAdapter() }

    override fun initViews() {
        showEmptyState()
        setHasOptionsMenu(true)
        (activity as MainActivity).setSupportActionBar(binding.searchToolbar)
        binding.searchToolbar.title = ""
        initAdapter()
        with(binding) {
            addItemDecoration(this.mainFragmentRecyclerViewBooks)
        }
        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                searchPresenter::onSearchQueryChange
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                searchPresenter.onSearchQueryChange(query)
                return false
            }
        })

        with(searchView) {
            queryHint = context.getString(R.string.search)
            setIconifiedByDefault(false)
            isIconified = false
            setQuery(searchPresenter.currentQuery, true)
        }
        filterChangedBehavior()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_filter -> {
                searchPresenter.onFilterClick()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addItemDecoration(recyclerView: RecyclerView) {
        val orientation = (recyclerView.layoutManager as? LinearLayoutManager)?.orientation
        val divider =
            AppCompatResources.getDrawable(recyclerView.context, R.drawable.book_item_divider)

        safeLet(orientation, divider) { orientation, divider ->
            val itemDecoration = DividerItemDecoration(recyclerView.context, orientation)
            itemDecoration.setDrawable(divider)
            recyclerView.addItemDecoration(itemDecoration)
        }
    }

    override fun showLoadingState() {
        binding.searchFragmentAnimator.visibleChildId = R.id.loading_state
    }

    override fun showEmptyState() {
        binding.searchFragmentAnimator.visibleChildId = R.id.empty_state
    }

    override fun showContentState() {
        binding.searchFragmentAnimator.visibleChildId = R.id.content_state
    }

    override fun bindBookListItems(newItems: List<GoogleBookItem>) {
        googleBookSearchAdapter.setItems(newItems)
    }

    override fun showToastOnError() {
        Toast.makeText(context, getString(R.string.something_went_wrong), Toast.LENGTH_LONG)
            .show()
    }

    private fun initAdapter() {
        with(binding) {
            mainFragmentRecyclerViewBooks.apply {
                adapter = googleBookSearchAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    private fun filterChangedBehavior() {
        val filter = interactor.getFilterParameter()?.let { FilterEnum.valueOf(it) }
        if (filter != null && filter != FilterEnum.ALL) {
            binding.searchToolbar.menu.findItem(R.id.action_filter).icon = resources.getDrawable(R.drawable.ic_filter_indicated)
        }
    }
}
