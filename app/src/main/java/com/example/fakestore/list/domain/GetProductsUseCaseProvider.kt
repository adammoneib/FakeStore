package com.example.fakestore.list.domain

import com.example.fakestore.core.DefaultApiClient
import com.example.fakestore.list.data.ProductRemoteRepo
import com.example.fakestore.list.data.ProductsRemoteDataSource

object GetProductsUseCaseProvider {

    private fun provideRemoteDataSource() =
        DefaultApiClient.getInstance().create(ProductsRemoteDataSource::class.java)

    private fun provideProductsRepo() = ProductRemoteRepo(provideRemoteDataSource())

    fun provide(): GetProductsUseCase {
        return GetProductsUseCase(provideProductsRepo())
    }
}