package com.example.orderapp.order_feature.presentation.mapper

import com.example.orderapp.core.domain.model.Deliverer
import com.example.orderapp.order_feature.presentation.state.DelivererListItem

fun Deliverer.toDelivererListItem(): DelivererListItem {
    return DelivererListItem(
        delivererId = delivererId,
        name = name
    )
}