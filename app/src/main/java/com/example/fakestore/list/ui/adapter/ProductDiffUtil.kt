package com.example.fakestore.list.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.fakestore.list.data.model.ProductRemote

object ProductDiffUtil: DiffUtil.ItemCallback<ProductRemote>() {
    override fun areItemsTheSame(oldItem: ProductRemote, newItem: ProductRemote): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductRemote, newItem: ProductRemote): Boolean {
        return oldItem.id == newItem.id
                && oldItem.title == newItem.title
                && oldItem.price == newItem.price
                && oldItem.category == newItem.category
                && oldItem.description == newItem.description
                && oldItem.image == newItem.image
                && oldItem.rating == newItem.rating
    }
}