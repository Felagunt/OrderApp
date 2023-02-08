package com.example.orderapp.core.data.local

import androidx.room.*
import com.example.orderapp.core.data.local.entities.OrderEntity
import com.example.orderapp.core.data.local.entities.OrderProductEntity
import com.example.orderapp.core.data.local.entities.OrderWithProductsDataObject

@Dao
interface OrderDao {

    @Transaction
    @Query("SELECT * FROM orderentity")
    suspend fun getOrderWithProducts(): List<OrderWithProductsDataObject>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(orderEntity: OrderEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertOrderProductEntities(orderProductEntities: List<OrderProductEntity>)
}