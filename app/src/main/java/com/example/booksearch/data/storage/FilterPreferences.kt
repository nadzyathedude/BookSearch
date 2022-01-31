package com.example.booksearch.data.storage

import android.content.SharedPreferences
import com.example.booksearch.data.base.BasePreferences

class FilterPreferences(preferences: SharedPreferences) :
    BasePreferences(preferences, "filter")

