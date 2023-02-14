package com.example.orderapp.order_feature.presentation.state

data class OrderListItem(
    val orderId: String,
    val delivererName: String,
    val totalAmount: Double,
    val orderDate: String
)
