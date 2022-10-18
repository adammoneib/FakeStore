package com.example.fakestore.list.data

import com.example.fakestore.list.data.model.ProductRemote
import io.reactivex.Single
import retrofit2.http.GET

interface ProductsRemoteDataSource {

    @GET("products")
    fun getProducts(): Single<List<ProductRemote>>
}