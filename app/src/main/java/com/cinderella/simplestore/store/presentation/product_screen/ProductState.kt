package com.cinderella.simplestore.store.presentation.product_screen

import com.cinderella.simplestore.store.domain.model.Product

data class ProductState (
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String = ""
)
