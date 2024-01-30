package com.cinderella.simplestore.store.data.remote

import com.cinderella.simplestore.store.domain.model.Product
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("products/{id}")
    suspend fun getProduct(id: Int): Product
}