package com.example.fakestore.list.data

import com.example.fakestore.list.data.model.ProductRemote
import com.example.fakestore.list.domain.ProductsRepo
import io.reactivex.Single

class ProductRemoteRepo(
    val remote: ProductsRemoteDataSource
): ProductsRepo {
    override fun getProducts(): Single<List<ProductRemote>> {
        return remote.getProducts()
    }
}