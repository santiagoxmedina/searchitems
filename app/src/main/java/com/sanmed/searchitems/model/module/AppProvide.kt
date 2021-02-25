package com.sanmed.searchitems.model.module

import android.content.Context
import androidx.room.Room
import com.sanmed.searchitems.model.dao.ItemDao
import com.sanmed.searchitems.model.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppProvide {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "search-items-database.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideItemDao(db: AppDatabase): ItemDao {
        return db.itemDao()
    }
}