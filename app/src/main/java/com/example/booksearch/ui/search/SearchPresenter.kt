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
    val RESULT_KEY = "1"
    private val googleBooksInteractor: GoogleBooksInteractor by inject()

    var filterParameter = FilterEnum.ALL.key
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
            router.setResultListener(RESULT_KEY) { preparedQuery ->
               // loadBooks("$preparedQuery:$query")
                filterParameter = preparedQuery.toString()
            }
            loadBooks("$filterParameter:$query")
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
