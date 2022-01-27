package com.example.booksearch.data.storage

import android.content.SharedPreferences

class FilterPreferences(preferences: SharedPreferences) :
    BasePreferences(preferences, "filter")

abstract class BasePreferences(
    private val preferences: SharedPreferences,
    private val key: String
) {
    fun getValue() = preferences.getString(key, "")
    fun get() = preferences.getString(key, null)
    fun set(value: String) = preferences.edit().putString(key, value).apply()
}
