package com.example.fakestore.list.data.model

data class ProductRemote(
    val id: Int,
    val title: String,
    val price: Float,
    val description: String,
    val category: String,
    val image: String,
    val rating: RatingRemote
)