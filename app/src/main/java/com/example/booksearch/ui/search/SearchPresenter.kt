package com.example.booksearch.ui.search

import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader
import com.example.booksearch.domain.interactor.GoogleBooksInteractor
import com.example.booksearch.ui.base.BasePresenter
import com.example.booksearch.ui.base.Screens
import com.example.booksearch.ui.filter.adapter.FilterEnum
import com.example.booksearch.ui.search.adapter.GoogleBookItem
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.MvpView

@InjectViewState
class SearchPresenter(router: Router, private val interactor: GoogleBooksInteractor) :
    MvpPresenter<SearchView>() {

    var filterParameter: FilterEnum? = FilterEnum.ALL
    val booksListLD: MutableLiveData<List<GoogleBookItem>> = MutableLiveData()
    var currentQuery = ""
    private val booksListLiveData: MutableLiveData<List<GoogleBookItem>> = MutableLiveData()
    protected val compositeDisposable = CompositeDisposable()

    fun search(query: String) {
        viewState.loadBooks(query)
        viewState.fetchData(query)
        viewState.navigateToFiltersScreen()

    }


    fun load(query: String) {
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
//
//    override fun fetchData(query: String) {
//
//        currentQuery = query
//
//        if (query.isBlank()) {
//            booksListLiveData.value = emptyList()
//            return
//        }
//        val preparedQuery = filterParameter?.key + ":" + query
//        loadBooks(preparedQuery)
//    }
//
//    override fun navigateToFiltersScreen() {
//        router.navigateTo(Screens.Filter())
//    }
}}
