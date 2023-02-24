package com.example.orderapp.order_feature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orderapp.core.domain.model.Deliverer
import com.example.orderapp.order_feature.domain.repository.OrderRepository
import com.example.orderapp.order_feature.domain.use_case.FilterListByNameUseCase
import com.example.orderapp.order_feature.domain.use_case.SortListByNameUseCase
import com.example.orderapp.order_feature.presentation.mapper.toDelivererListItem
import com.example.orderapp.order_feature.presentation.state.DelivererListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderChooseDelivererViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
    private val sortListByNameUseCase: SortListByNameUseCase,
    private val filterListByNameUseCase: FilterListByNameUseCase
): ViewModel() {

    private lateinit var deliverers: List<Deliverer>

    var deliverersToShow by mutableStateOf<List<DelivererListItem>>(emptyList())
        private set

    var delivererSearchQuery by mutableStateOf("")
        private set
    
    init {
        viewModelScope.launch {
            deliverers = orderRepository.getDeliverers()
            setupDelivererToShow()
        }
    }

    fun onSearchQueryChange(newValue: String) {
        delivererSearchQuery = newValue
        setupDelivererToShow()
    }

    private fun setupDelivererToShow() {
        deliverersToShow = filterListByNameUseCase(
            sortListByNameUseCase(deliverers), delivererSearchQuery
        ).map { deliverer ->
            deliverer.toDelivererListItem()
        }
    }
}