package com.example.booksearch.ui.search

import android.os.Bundle
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
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import com.example.booksearch.ui.search.adapter.GoogleBookSearchAdapter
import com.example.booksearch.utils.safeLet
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class SearchFragment : MvpAppCompatFragment(), com.example.booksearch.ui.search.SearchView {

    @InjectPresenter
    lateinit var searchPresenter: SearchPresenter
    private val googleBookSearchAdapter by lazy { GoogleBookSearchAdapter() }
    private val binding by lazy {
        FSearchBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as MainActivity).setSupportActionBar(VToolbarSearchBinding.bind(binding.root).searchToolbar)
        val binding =
            FSearchBinding.inflate(inflater, container, false)
        with(binding) {
            mainFragmentRecyclerViewBooks.adapter = googleBookSearchAdapter
            addItemDecoration(this.mainFragmentRecyclerViewBooks)
            return binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        binding.mainFragmentWelcomeTextview.isVisible = true
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
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

    private fun initListener() {
        VToolbarSearchBinding.bind(binding.root).toolbarFiltersButton.setOnClickListener {
            searchPresenter.onFilterClick()
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
}
