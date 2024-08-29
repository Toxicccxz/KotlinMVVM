package com.xavier.kotlinmvvm.usecase.errors

import com.xavier.kotlinmvvm.data.error.Error

interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}