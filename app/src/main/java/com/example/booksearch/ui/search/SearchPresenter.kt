package com.example.booksearch.ui.search

import androidx.lifecycle.MutableLiveData
import com.arellomobile.mvp.InjectViewState
import com.example.booksearch.domain.interactor.GoogleBooksInteractor
import com.example.booksearch.ui.base.BasePresenter
import com.example.booksearch.ui.base.Screens
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

@InjectViewState
class SearchPresenter(router: Router, val interactor: GoogleBooksInteractor) :
    BasePresenter(router), SearchView {

    var filterParameter: FilterEnum? = FilterEnum.ALL
    val booksListLD: MutableLiveData<List<GoogleBookItem>> = MutableLiveData()
    var currentQuery = ""
    private val booksListLiveData: MutableLiveData<List<GoogleBookItem>> = MutableLiveData()

    override fun loadBooks(query: String) {
        compositeDisposable.add(
            interactor
                .searchBooks(query)
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
    }

    override fun fetchData(query: String) {

        currentQuery = query

        if (query.isBlank()) {
            booksListLiveData.value = emptyList()
            return
        }
        val preparedQuery = filterParameter?.key + ":" + query
        loadBooks(preparedQuery)
    }

    override fun navigateToFiltersScreen() {
        router.navigateTo(Screens.Filter())
    }
}
