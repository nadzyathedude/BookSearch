package com.example.booksearch.ui.filter.adapter

data class FilterItem(val title: Int, val parameter: FilterEnum, var isSelected : Boolean)

enum class FilterEnum(val key: String) {
  ALL("q"),
  TITLE("intitle"),
  AUTHOR("inauthor"),
  PUBLISHER("inpublisher"),
  SUBJECT("subject")
}
