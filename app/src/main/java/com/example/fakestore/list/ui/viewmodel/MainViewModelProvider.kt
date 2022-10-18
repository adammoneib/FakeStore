package com.example.fakestore.list.ui.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.fakestore.list.domain.GetProductsUseCaseProvider

object MainViewModelProvider {

    private fun provideGetProductsUseCase() = GetProductsUseCaseProvider.provide()

    fun provide(owner: AppCompatActivity) = ViewModelProvider(
        owner = owner,
        MainViewModelFactory(
            useCase = provideGetProductsUseCase()
        )
    ).get(MainViewModel::class.java)
}