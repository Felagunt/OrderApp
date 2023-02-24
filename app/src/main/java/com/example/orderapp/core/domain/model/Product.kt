package com.example.orderapp.core.domain.model

import com.example.orderapp.core.domain.SelectAndSortableByName

data class Product(
    val productId: String,
    override val name: String,
    val pricePerAmount: Float
): SelectAndSortableByName
