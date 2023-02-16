package com.example.orderapp.core.data.mapper

import com.example.orderapp.core.data.local.entities.DelivererEntity
import com.example.orderapp.core.domain.model.Deliverer
import com.example.orderapp.core.domain.model.Product

fun DelivererEntity.toDeliverer(products: List<Product>): Deliverer {
    return Deliverer(
        delivererId = delivererId,
        name = name,
        products = products
    )
}