package com.cinderella.simplestore.store.data.repository

import arrow.core.Either
import com.cinderella.simplestore.store.data.remote.ProductApi
import com.cinderella.simplestore.store.domain.model.NetworkError
import com.cinderella.simplestore.store.domain.model.Product
import com.cinderella.simplestore.store.domain.model.toNetworkError
import com.cinderella.simplestore.store.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(private val productApi: ProductApi) :
    ProductRepository {
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch { withContext(Dispatchers.IO) { productApi.getProducts() } }.mapLeft {
            it.toNetworkError()
        }
    }

    override suspend fun getProduct(id: Int): Either<NetworkError, Product> {
        return Either.catch { withContext(Dispatchers.IO) { productApi.getProduct(id) } }.mapLeft {
            it.toNetworkError()
        }
    }

}