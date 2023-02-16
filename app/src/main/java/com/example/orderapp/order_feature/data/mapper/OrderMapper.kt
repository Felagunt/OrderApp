package com.example.orderapp.order_feature.data.mapper

import com.example.orderapp.core.data.local.entities.OrderEntity
import com.example.orderapp.order_feature.domain.model.Order

fun Order.toOrderEntity(delivererName: String): OrderEntity {
    return OrderEntity(
        orderId = orderId,
        date = date,
        delivererName = delivererName,
        delivererTime = delivererTime
    )
}