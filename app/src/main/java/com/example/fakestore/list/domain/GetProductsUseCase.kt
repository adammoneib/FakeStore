package com.example.fakestore.list.domain

import com.example.fakestore.list.data.model.ProductRemote
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetProductsUseCase(
    val repo: ProductsRepo
) {

    operator fun invoke(): Single<List<ProductRemote>> {
        return repo.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}