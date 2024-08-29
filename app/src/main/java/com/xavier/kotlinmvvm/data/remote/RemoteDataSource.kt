package com.xavier.kotlinmvvm.data.remote

import com.xavier.kotlinmvvm.data.Resource
import com.xavier.kotlinmvvm.data.dto.recipes.Recipes

internal interface RemoteDataSource {
    suspend fun requestRecipes(): Resource<Recipes>
}