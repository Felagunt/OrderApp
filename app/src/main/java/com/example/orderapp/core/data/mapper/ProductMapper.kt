package com.example.orderapp.core.data.mapper

import com.example.orderapp.core.data.local.entities.ProductEntity
import com.example.orderapp.core.domain.model.Product

fun ProductEntity.toProduct(): Product {
    return Product(
        productId = productId,
        name = name,
        pricePerAmount = pricePerAmount
    )
}