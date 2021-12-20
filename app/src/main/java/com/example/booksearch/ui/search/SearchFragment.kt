package com.example.booksearch.ui.search

import android.view.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.MainActivity
import com.example.booksearch.R
import com.example.booksearch.databinding.FSearchBinding
import com.example.booksearch.databinding.VToolbarSearchBinding
import com.example.booksearch.ui.base.BaseFragment
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

    override fun initViews() {
        binding.mainFragmentWelcomeTextview.isVisible = true
        setHasOptionsMenu(true)
        (activity as MainActivity).setSupportActionBar(VToolbarSearchBinding.bind(binding.root).searchToolbar)
        initAdapter()
        with(binding) {
            addItemDecoration(this.mainFragmentRecyclerViewBooks)
        }
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater
        menu.findItem(R.id.action_search).expandActionView()

        val searchView: SearchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                newText.let(searchPresenter::fetchData)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                query.let { searchPresenter.fetchData(it) }
                return false
            }
        })

        with(searchView) {
            queryHint = context.getString(R.string.search)
            setIconifiedByDefault(false)
            isIconified = false
            setQuery(searchPresenter.currentQuery, true)
        }
    }

    private fun addItemDecoration(recyclerView: RecyclerView) {
        val orientation = (recyclerView.layoutManager as? LinearLayoutManager)?.orientation
        val divider = AppCompatResources.getDrawable(recyclerView.context, R.drawable.divider)

        safeLet(orientation, divider) { orientation, divider ->
            val itemDecoration = DividerItemDecoration(recyclerView.context, orientation)
            itemDecoration.setDrawable(divider)
            recyclerView.addItemDecoration(itemDecoration)
        }
    }

    override fun showProgressBar() {
        binding.mainFragmentProgressBar.root.isVisible = true
    }

    override fun hideProgressBar() {
        binding.mainFragmentProgressBar.root.isVisible = false
    }

    override fun hideWelcomePhrase() {
        binding.mainFragmentWelcomeTextview.isVisible = false
    }

    override fun bindBookListItems(newItems: List<GoogleBookItem>) {
        googleBookSearchAdapter.setItems(newItems)
    }

    private fun initAdapter() {
        with(binding) {
            mainFragmentRecyclerViewBooks.apply {
                adapter = googleBookSearchAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }
}
