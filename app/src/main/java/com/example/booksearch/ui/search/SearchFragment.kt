package com.example.booksearch.ui.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.R
import com.example.booksearch.databinding.FSearchBinding
import com.example.booksearch.ui.MainActivity
import com.example.booksearch.ui.base.BaseFragment
import com.example.booksearch.ui.filter.FilterFragment
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import com.example.booksearch.ui.search.adapter.GoogleBookSearchAdapter
import com.example.booksearch.utils.safeLet
import moxy.presenter.InjectPresenter

class SearchFragment :
    BaseFragment<FSearchBinding>(FSearchBinding::inflate),
    com.example.booksearch.ui.search.SearchView {

    @InjectPresenter
    lateinit var searchPresenter: SearchPresenter
    private val googleBookSearchAdapter by lazy { GoogleBookSearchAdapter() }

    override fun onResume() {
        super.onResume()
        binding.searchView.clearFocus()
    }

    override fun initViews() {
        val searchView = binding.searchView
        searchView.clearFocus()
        showEmptyState()
        setHasOptionsMenu(true)
        (activity as MainActivity).setSupportActionBar(binding.searchToolbar)
        binding.searchToolbar.title = ""

        initAdapter()
        with(binding) {
            addItemDecoration(this.mainFragmentRecyclerViewBooks)
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                searchPresenter.onSearchQueryChange(newText)
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
      //  setBadgeOnFilterIcon()
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

    override fun hideKeyboard() {
        val imm =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

    private fun initAdapter() {
        with(binding) {
            mainFragmentRecyclerViewBooks.apply {
                adapter = googleBookSearchAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun setBadgeOnFilterIcon() {
        binding.searchToolbar.menu.getItem(0).icon =
            ResourcesCompat.getDrawable(resources, R.drawable.ic_filter_indicated, context?.theme)
    }
}
