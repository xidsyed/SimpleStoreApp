package com.cinderella.simplestore.store.presentation.product_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinderella.simplestore.store.domain.repository.ProductRepository
import com.cinderella.simplestore.store.presentation.util.sendEvent
import com.cinderella.simplestore.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state: MutableStateFlow<ProductState> = MutableStateFlow(ProductState())
    val state = _state.asStateFlow()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            productRepository.getProducts().onRight {list ->
                _state.update { it.copy(products = list) }

            }.onLeft { error ->
                _state.update { it.copy(error = error.apiError.name) }
                sendEvent(Event.Toast(error.apiError.name))
            }
            _state.update { it.copy(isLoading = false) }
        }
    }

}