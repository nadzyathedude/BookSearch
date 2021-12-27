package com.example.booksearch.ui.search

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

    private val interactor: GoogleBooksInteractor by inject()
    var filterParameter: FilterEnum? = FilterEnum.ALL
    var currentQuery = ""
    override val compositeDisposable = CompositeDisposable()

    private fun loadBooks(query: String) {
        viewState.showLoadingState()
        compositeDisposable.add(
            interactor
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
            val preparedQuery = filterParameter?.key + ":" + query
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
