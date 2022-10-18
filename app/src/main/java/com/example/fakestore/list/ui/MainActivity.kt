package com.example.fakestore.list.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakestore.DetailsActivity
import com.example.fakestore.databinding.ActivityMainBinding
import com.example.fakestore.list.data.model.ProductRemote
import com.example.fakestore.list.ui.adapter.ProductsListAdapter
import com.example.fakestore.list.ui.viewmodel.MainViewModel
import com.example.fakestore.list.ui.viewmodel.MainViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel
    private lateinit var listAdapter: ProductsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
        initData()
    }

    private fun initUi() {
        listAdapter = ProductsListAdapter { openDetailsActivity(it) }
        binding.itemsRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listAdapter
            setHasFixedSize(true)
        }
    }

    private fun initData() {
        mainViewModel = MainViewModelProvider.provide(this)
        mainViewModel.productViewState.observe(this) { state ->
            state?.let {
                setViewState(it)
            }
        }
        mainViewModel.getProducts()
    }

    private fun setViewState(state: ProductViewState) {
        when (state) {
            ProductViewState.Loading -> {}
            is ProductViewState.Success -> {
                listAdapter.submitList(state.products)
            }
            ProductViewState.Error -> {}
        }
    }

    private fun openDetailsActivity(product: ProductRemote) {
        startActivity(DetailsActivity.getIntent(this, product))
    }
}