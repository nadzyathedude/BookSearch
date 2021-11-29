package com.example.booksearch

import android.os.Bundle
import android.view.Menu
import com.example.booksearch.databinding.ActivityMainBinding
import com.example.booksearch.ui.search.SearchFragment
import moxy.MvpAppCompatActivity
import moxy.MvpView

class MainActivity : MvpAppCompatActivity(), MvpView {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(binding.mainActivityToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, SearchFragment())
                .commitAllowingStateLoss()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}
