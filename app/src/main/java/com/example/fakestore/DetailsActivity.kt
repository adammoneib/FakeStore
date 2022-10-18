package com.example.fakestore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.fakestore.databinding.ActivityDetailsBinding
import com.example.fakestore.list.data.model.ProductRemote

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val product: ProductRemote = intent.extras?.get(KEY_PRODUCT_OBJECT) as ProductRemote

        binding.productName.text = product.title
        binding.ProductDescription.text = product.description
        binding.productPrice.text = "${product.price}$"
        Glide.with(this)
            .load(product.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.productImage)
        binding.rating.rating = product.rating.rate
    }

    companion object {
        private const val KEY_PRODUCT_OBJECT = "KEY_PRODUCT_OBJECT"

        fun getIntent(context: Context, product: ProductRemote): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(KEY_PRODUCT_OBJECT, product)
            }
        }
    }
}