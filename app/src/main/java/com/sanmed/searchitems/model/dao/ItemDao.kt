package com.sanmed.searchitems.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sanmed.searchitems.model.entity.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun getAll(): Flow<List<Item>>

    @Query("SELECT * FROM item WHERE itemId = (:itemIds)")
    fun loadByIds(itemIds: String): LiveData<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll( items: List<Item>)

    @Delete
    suspend fun delete(item: Item)

    @Query("DELETE FROM Item")
    suspend fun deleteAll()

    @Transaction
    suspend fun replace(items: List<Item>) {
        deleteAll()
        insertAll(items)
    }
}