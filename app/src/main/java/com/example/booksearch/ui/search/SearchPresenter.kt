package com.example.booksearch.ui.search

import androidx.lifecycle.MutableLiveData
import com.example.booksearch.domain.interactor.GoogleBooksInteractor
import com.example.booksearch.ui.base.BasePresenter
import com.example.booksearch.ui.base.Screens
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.InjectViewState
import org.koin.core.component.inject

@InjectViewState
class SearchPresenter(private var searchQuery: String) :
    BasePresenter<SearchView>() {

    private val interactor: GoogleBooksInteractor by inject()
    var filterParameter: FilterEnum? = FilterEnum.ALL
    val booksListLD: MutableLiveData<List<GoogleBookItem>> = MutableLiveData()
    var currentQuery = ""
    private val booksListLiveData: MutableLiveData<List<GoogleBookItem>> = MutableLiveData()
    override val compositeDisposable = CompositeDisposable()

    private fun loadBooks(query: String) {
        viewState.hideWelcomePhrase()
        viewState.showProgressBar()
        compositeDisposable.add(
            interactor
                .searchBooks(searchQuery)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading.value = true }
                .doFinally { isLoading.value = false }
                .subscribe(
                    { responseBooksList ->
                        if (currentQuery.isBlank()) booksListLD.value = emptyList()
                        else booksListLD.value = responseBooksList
                    },
                    {}
                )
        )
        viewState.hideProgressBar()
    }

    fun fetchData(query: String) {

        currentQuery = query

        if (query.isBlank()) {
            booksListLiveData.value = emptyList()
            return
        }
        val preparedQuery = filterParameter?.key + ":" + query
        loadBooks(preparedQuery)
    }

    fun navigateToFiltersScreen() {
        router.navigateTo(Screens.Filter())
    }
}
