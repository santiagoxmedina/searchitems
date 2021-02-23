package com.sanmed.searchitems.module

import androidx.lifecycle.LiveData
import com.sanmed.searchitems.repository.IItemsRepository
import com.sanmed.searchitems.repository.TestItemRepository
import com.sanmed.searchitems.ui.main.IItemView
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class ItemsRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindIItemsRepository(iItemsRepositoryImpl: TestItemRepository):IItemsRepository
}