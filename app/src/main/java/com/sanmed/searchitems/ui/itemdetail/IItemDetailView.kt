package com.sanmed.searchitems.ui.itemdetail

import com.sanmed.searchitems.ui.main.IItemView

interface IItemDetailView: IItemView{
    fun getQuantity():String
    fun getSellerLink():String
    fun getSellerDate():String
    fun getSellerReputation():String
}