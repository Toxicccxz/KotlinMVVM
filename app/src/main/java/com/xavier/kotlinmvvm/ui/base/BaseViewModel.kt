package com.xavier.kotlinmvvm.ui.base

import androidx.lifecycle.ViewModel
import com.xavier.kotlinmvvm.usecase.errors.ErrorManager

import javax.inject.Inject


abstract class BaseViewModel : ViewModel() {
    /**Inject Singleton ErrorManager
     * Use this errorManager to get the Errors
     */
    @Inject
    lateinit var errorManager: ErrorManager
}