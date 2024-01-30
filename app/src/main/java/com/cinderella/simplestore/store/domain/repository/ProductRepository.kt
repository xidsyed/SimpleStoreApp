package com.cinderella.simplestore.store.domain.repository

import arrow.core.Either
import com.cinderella.simplestore.store.domain.model.NetworkError
import com.cinderella.simplestore.store.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): Either<NetworkError,List<Product>>
    suspend fun getProduct(id: Int): Either<NetworkError, Product>
}