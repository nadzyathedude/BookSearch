package com.example.booksearch.ui.filter.adapter

data class FilterItem(val title: Int, val parameter: FilterEnum)

enum class FilterEnum(val key: String) {
  ALL("q"),
  TITLE("intitle"),
  AUTHOR("inauthor"),
  PUBLISHER("inpublisher"),
  SUBJECT("subject")
}
