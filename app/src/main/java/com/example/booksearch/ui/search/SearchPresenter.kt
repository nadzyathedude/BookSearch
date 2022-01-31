package com.example.booksearch.ui.search

import com.example.booksearch.domain.interactor.FilterInteractor
import com.example.booksearch.domain.interactor.GoogleBooksInteractor
import com.example.booksearch.ui.base.BasePresenter
import com.example.booksearch.ui.base.Screens
import com.example.booksearch.ui.filter.adapter.FilterEnum
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.InjectViewState
import org.koin.core.component.inject

@InjectViewState
class SearchPresenter() :
    BasePresenter<SearchView>() {

    private val googleBooksInteractor: GoogleBooksInteractor by inject()
    private val filterInteractor: FilterInteractor by inject()
    var filterParameter: FilterEnum? = FilterEnum.ALL
    var currentQuery = ""
    override val compositeDisposable = CompositeDisposable()

    private fun loadBooks(query: String) {
        viewState.showLoadingState()
        compositeDisposable.add(
            googleBooksInteractor
                .searchBooks(query)
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(viewState::showContentState)
                .subscribe(
                    { responseBooksList ->
                        viewState.bindBookListItems(responseBooksList)
                    },
                    { viewState.showToastOnError() }
                )
        )
    }

    fun onSearchQueryChange(query: String) {
        if (query.isEmpty()) {
            viewState.showEmptyState()
        } else {
            currentQuery = query
            val preparedQuery =
                filterInteractor.getFilterParameter()?.let { FilterEnum.valueOf(it).key }
                    .toString() + ":" + query
            loadBooks(preparedQuery)
            viewState.showContentState()
        }
    }

    fun onFilterClick() {
        navigateToFiltersScreen()
    }

    private fun navigateToFiltersScreen() {
        router.navigateTo(Screens.Filter())
    }
}
