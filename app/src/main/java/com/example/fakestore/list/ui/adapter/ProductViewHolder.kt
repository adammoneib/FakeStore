package com.example.fakestore.list.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.fakestore.databinding.ProductListItemBinding
import com.example.fakestore.list.data.model.ProductRemote

class ProductViewHolder(
    private val binding: ProductListItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bindItem(product: ProductRemote, productClicked: (ProductRemote) -> Unit){
        binding.root.setOnClickListener{
            productClicked(product)
        }

        Glide.with(itemView.context)
            .load(product.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.productImage)

        binding.productName.text = product.title
        binding.productPrice.text = product.price.toString()
    }
}