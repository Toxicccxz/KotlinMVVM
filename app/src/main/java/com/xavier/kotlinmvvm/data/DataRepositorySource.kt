package com.xavier.kotlinmvvm.data

import com.xavier.kotlinmvvm.data.dto.login.LoginRequest
import com.xavier.kotlinmvvm.data.dto.login.LoginResponse
import com.xavier.kotlinmvvm.data.dto.recipes.Recipes
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun requestRecipes(): Flow<Resource<Recipes>>
    suspend fun doLogin(loginRequest: LoginRequest): Flow<Resource<LoginResponse>>
    suspend fun addToFavourite(id: String): Flow<Resource<Boolean>>
    suspend fun removeFromFavourite(id: String): Flow<Resource<Boolean>>
    suspend fun isFavourite(id: String): Flow<Resource<Boolean>>
}