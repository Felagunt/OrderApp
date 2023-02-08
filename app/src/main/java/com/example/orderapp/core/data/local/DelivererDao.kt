package com.example.orderapp.core.data.local

import androidx.room.*
import com.example.orderapp.core.data.local.entities.DelivererEntity
import com.example.orderapp.core.data.local.entities.DelivererWithProductDataObject

@Dao
interface DelivererDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertDeliverer(delivererEntity: DelivererEntity)

    @Transaction
    @Query("SELECT * FROM delivererentity")
    suspend fun getDeliverers(): List<DelivererWithProductDataObject>

    @Query("SELECT name FROM delivererentity WHERE delivererId = :delivererId")
    suspend fun getDelivererNameById(delivererId: String): String
}