package com.cinderella.simplestore.di

import com.cinderella.simplestore.store.data.repository.ProductRepositoryImpl
import com.cinderella.simplestore.store.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository
}