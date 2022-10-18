package com.example.fakestore.list.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestore.R
import com.example.fakestore.databinding.ProductListItemBinding
import com.example.fakestore.list.data.model.ProductRemote

class ProductsListAdapter(
    private val productClicked: (ProductRemote) -> Unit
): ListAdapter<ProductRemote, RecyclerView.ViewHolder>(ProductDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.product_list_item, parent, false)
        return ProductViewHolder(ProductListItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductViewHolder).bindItem(getItem(position), productClicked)
    }
}