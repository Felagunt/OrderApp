package com.example.orderapp.order_feature.di

import com.example.orderapp.core.data.local.DelivererDao
import com.example.orderapp.core.data.local.OrderDao
import com.example.orderapp.core.data.local.ProductDao
import com.example.orderapp.order_feature.data.repository.OrderRepositoryImpl
import com.example.orderapp.order_feature.domain.repository.OrderRepository
import com.example.orderapp.order_feature.domain.use_case.FilterListByNameUseCase
import com.example.orderapp.order_feature.domain.use_case.SortListByNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OrderFeatureModule {

    @Provides
    @Singleton
    fun provideOrderRepository(
        orderDao: OrderDao,
        delivererDao: DelivererDao,
        productDao: ProductDao
    ): OrderRepository {
        return OrderRepositoryImpl(orderDao, delivererDao, productDao)
    }

    @Provides
    @Singleton
    fun provideFilterListByNameUseCase(): FilterListByNameUseCase {
        return FilterListByNameUseCase()
    }

    @Provides
    @Singleton
    fun provideSortListByNameUseCase(): SortListByNameUseCase {
        return SortListByNameUseCase()
    }
}