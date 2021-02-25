package com.sanmed.searchitems.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey val itemId: String,
    @ColumnInfo(name = "name") val itemName: String,
    @ColumnInfo(name = "price") val itemPrice: String,
    @ColumnInfo(name = "link") val itemLink: String,
    @ColumnInfo(name = "thumbnail") val itemThumbnail: String,
    @ColumnInfo(name = "quantity") val itemQuantity: String,
    @ColumnInfo(name = "seller-link") val itemSellerLink: String,
    @ColumnInfo(name = "seller-date") val itemSellerDate: String,
    @ColumnInfo(name = "seller-reputation") val itemSellerReputation: String
)

