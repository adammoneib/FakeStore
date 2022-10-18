package com.example.fakestore.list.domain

import com.example.fakestore.list.data.model.ProductRemote
import io.reactivex.Single

interface ProductsRepo {

    fun getProducts(): Single<List<ProductRemote>>
}