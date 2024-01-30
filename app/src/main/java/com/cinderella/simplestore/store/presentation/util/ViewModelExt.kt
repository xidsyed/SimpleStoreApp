package com.cinderella.simplestore.store.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinderella.simplestore.util.Event
import com.cinderella.simplestore.util.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sendEvent(event: Event) {
    viewModelScope.launch {
        EventBus.send(event)
    }
}