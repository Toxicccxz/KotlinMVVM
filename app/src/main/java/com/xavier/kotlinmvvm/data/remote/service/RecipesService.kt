package com.xavier.kotlinmvvm.data.remote.service

import com.xavier.kotlinmvvm.data.dto.recipes.RecipesItem
import retrofit2.Response
import retrofit2.http.GET

interface RecipesService {
    @GET("recipes.json")
    suspend fun fetchRecipes(): Response<List<RecipesItem>>
}