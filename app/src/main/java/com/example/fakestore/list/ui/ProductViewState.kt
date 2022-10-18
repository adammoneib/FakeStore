package com.example.fakestore.list.ui

import com.example.fakestore.list.data.model.ProductRemote

sealed class ProductViewState {
    object Loading: ProductViewState()
    data class Success(val products: List<ProductRemote>) : ProductViewState()
    object Error: ProductViewState()
}
