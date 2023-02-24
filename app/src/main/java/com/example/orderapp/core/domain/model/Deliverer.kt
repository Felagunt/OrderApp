package com.example.orderapp.core.domain.model

import com.example.orderapp.core.domain.SelectAndSortableByName

data class Deliverer(
    val delivererId: String,
    override val name: String,
    val products: List<Product>
): SelectAndSortableByName
