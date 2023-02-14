package com.example.orderapp.order_feature.presentation.mapper

import com.example.orderapp.order_feature.domain.model.BoughtProduct
import com.example.orderapp.order_feature.presentation.state.ProductListItem

fun BoughtProduct.toProductListItem(): ProductListItem {
    return ProductListItem(
        id = productId,
        name = name,
        pricePerAmount = pricePerAmount,
        selectedAmount = amount,
        isExpanded = false
    )
}