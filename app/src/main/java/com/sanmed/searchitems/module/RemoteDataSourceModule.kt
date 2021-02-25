package com.sanmed.searchitems.module

import com.sanmed.searchitems.datasource.IRemoteDataSource
import com.sanmed.searchitems.datasource.MercadoLibreDataSource
import com.sanmed.searchitems.datasource.TestRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Singleton
    @Binds
    abstract fun bindIRemoteDataSource(iRemoteDataSource:MercadoLibreDataSource):IRemoteDataSource
}