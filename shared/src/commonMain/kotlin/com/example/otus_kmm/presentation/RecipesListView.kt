package com.example.otus_kmm.presentation

import com.example.otus_kmm.models.Recipe

interface RecipesListView {
    fun setItemsFrom(list: List<Recipe>)
}