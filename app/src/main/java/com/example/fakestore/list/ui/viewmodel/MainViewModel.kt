package com.example.fakestore.list.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fakestore.list.domain.GetProductsUseCase
import com.example.fakestore.list.ui.ProductViewState
import io.reactivex.disposables.Disposable

class MainViewModel(
    private val useCase: GetProductsUseCase
): ViewModel() {

    private val productsLiveData = MutableLiveData<ProductViewState>()
    val productViewState: LiveData<ProductViewState>
    get() = productsLiveData

    private var disposable: Disposable? = null
    fun getProducts() {
        productsLiveData.value = ProductViewState.Loading

        disposable = useCase.invoke()
            .doOnSuccess {
                productsLiveData.value = ProductViewState.Success(it)
            }.doOnError {
                productsLiveData.value = ProductViewState.Error
            }.subscribe()
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}