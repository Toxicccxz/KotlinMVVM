package com.xavier.kotlinmvvm.data.remote

import com.xavier.kotlinmvvm.data.Resource
import com.xavier.kotlinmvvm.data.dto.recipes.Recipes
import com.xavier.kotlinmvvm.data.dto.recipes.RecipesItem
import com.xavier.kotlinmvvm.data.error.NETWORK_ERROR
import com.xavier.kotlinmvvm.data.error.NO_INTERNET_CONNECTION
import com.xavier.kotlinmvvm.data.remote.service.RecipesService
import com.xavier.kotlinmvvm.utils.NetworkConnectivity
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject
constructor(private val serviceGenerator: ServiceGenerator, private val networkConnectivity: NetworkConnectivity) : RemoteDataSource {
    override suspend fun requestRecipes(): Resource<Recipes> {
        val recipesService = serviceGenerator.createService(RecipesService::class.java)
        return when (val response = processCall(recipesService::fetchRecipes)) {
            is List<*> -> {
                Resource.Success(data = Recipes(response as ArrayList<RecipesItem>))
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}