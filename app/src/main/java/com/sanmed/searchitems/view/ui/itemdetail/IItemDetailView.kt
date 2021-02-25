package com.sanmed.searchitems.view.ui.itemdetail

import com.sanmed.searchitems.view.ui.main.IItemView

interface IItemDetailView: IItemView{
    fun getQuantity():String
    fun getSellerLink():String
    fun getSellerDate():String
    fun getSellerReputation():String
}