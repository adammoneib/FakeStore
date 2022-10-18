package com.example.fakestore.list.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fakestore.list.domain.GetProductsUseCase

class MainViewModelFactory(
    private val useCase: GetProductsUseCase
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                useCase = useCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}