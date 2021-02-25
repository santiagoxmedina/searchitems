package com.sanmed.searchitems.model.module

import com.sanmed.searchitems.model.datasource.ILocalDataSource
import com.sanmed.searchitems.model.datasource.IRemoteDataSource
import com.sanmed.searchitems.model.datasource.LocalDataSource
import com.sanmed.searchitems.model.datasource.MercadoLibreDataSource
import com.sanmed.searchitems.model.repository.IItemsRepository
import com.sanmed.searchitems.model.repository.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun bindILocalDataSource(iLocalDataSource: LocalDataSource): ILocalDataSource

    @Singleton
    @Binds
    abstract fun bindIItemsRepository(iItemsRepositoryImpl: ItemsRepository): IItemsRepository

    @Singleton
    @Binds
    abstract fun bindIRemoteDataSource(iRemoteDataSource:MercadoLibreDataSource):IRemoteDataSource


}