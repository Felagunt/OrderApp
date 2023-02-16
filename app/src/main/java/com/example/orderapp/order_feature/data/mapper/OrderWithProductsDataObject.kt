package com.example.orderapp.order_feature.data.mapper

import com.example.orderapp.core.data.local.entities.OrderWithProductsDataObject
import com.example.orderapp.order_feature.domain.model.BoughtProduct
import com.example.orderapp.order_feature.domain.model.Order

fun OrderWithProductsDataObject.toOrder(): Order {
    return Order(
        orderId = orderEntity.orderId,
        date = orderEntity.date,
        delivererTime = orderEntity.delivererTime,
        delivererName = orderEntity.delivererName,
        products = products.zip(orderProductEntities).map { pair ->
            BoughtProduct(
                pair.component1().productId,
                pair.component1().name,
                pair.component1().pricePerAmount,
                pair.component2().amount
            )
        }
    )
}