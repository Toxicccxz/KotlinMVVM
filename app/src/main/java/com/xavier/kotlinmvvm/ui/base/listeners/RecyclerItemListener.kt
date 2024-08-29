package com.xavier.kotlinmvvm.ui.base.listeners

import com.xavier.kotlinmvvm.data.dto.recipes.RecipesItem

interface RecyclerItemListener {
    fun onItemSelected(recipe : RecipesItem)
}