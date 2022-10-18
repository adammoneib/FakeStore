package com.example.fakestore.list.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RatingRemote(
    val rate: Float,
    val count: Int
): Parcelable
