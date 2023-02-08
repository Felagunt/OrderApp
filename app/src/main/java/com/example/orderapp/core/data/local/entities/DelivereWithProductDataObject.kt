package com.example.orderapp.core.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation

data class DelivererWithProductDataObject(
    @Embedded val delivererEntity: DelivererEntity,
    @Relation(
        parentColumn = "delivererId",
        entityColumn = "belongsToDeliverer"
    )
    val products: List<ProductEntity>
)
