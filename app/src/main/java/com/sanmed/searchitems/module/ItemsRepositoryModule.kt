package com.sanmed.searchitems.module

import com.sanmed.searchitems.repository.IItemsRepository
import com.sanmed.searchitems.repository.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class ItemsRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindIItemsRepository(iItemsRepositoryImpl: ItemsRepository):IItemsRepository
}