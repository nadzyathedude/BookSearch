package com.example.booksearch

import android.os.Bundle
import android.view.Menu
import com.example.booksearch.databinding.ActivityMainBinding
import com.example.booksearch.databinding.FSearchBinding
import com.example.booksearch.ui.search.SearchFragment
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatActivity
import moxy.MvpView
import org.koin.android.ext.android.inject

class MainActivity : MvpAppCompatActivity(), MvpView {
    private val router: Router by inject()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, SearchFragment())
                .commitAllowingStateLoss()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        menuInflater.inflate(R.menu.menu_filters, menu)
        return true
    }
}
