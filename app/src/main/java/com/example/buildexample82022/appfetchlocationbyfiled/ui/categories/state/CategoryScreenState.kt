package com.example.buildexample82022.appfetchlocationbyfiled.ui.categories.state

import com.example.buildexample82022.appfetchlocationbyfiled.api.model.Category

data class CategoryScreenState(
    val categories: List<Category> = emptyList(),
    val activeCategory: Category? = null
)
