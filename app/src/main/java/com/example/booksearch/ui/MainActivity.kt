package com.example.booksearch.ui

import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.booksearch.databinding.ActivityMainBinding
import com.example.booksearch.ui.base.BaseView

class MainActivity : MvpAppCompatActivity(), BaseView {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
}