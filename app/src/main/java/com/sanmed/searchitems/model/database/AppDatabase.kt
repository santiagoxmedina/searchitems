package com.sanmed.searchitems.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sanmed.searchitems.model.dao.ItemDao
import com.sanmed.searchitems.model.entity.Item

@Database(entities = [Item::class], version = 3,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}