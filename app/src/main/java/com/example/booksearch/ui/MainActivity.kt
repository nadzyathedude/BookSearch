package com.example.booksearch.ui

import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.booksearch.R
import com.example.booksearch.databinding.ActivityMainBinding
import com.example.booksearch.ui.base.BaseView
import ru.terrakok.cicerone.android.SupportFragmentNavigator

class MainActivity : MvpAppCompatActivity(), BaseView {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    //private val navigator = AppNavigator(this, R.id.container)
}