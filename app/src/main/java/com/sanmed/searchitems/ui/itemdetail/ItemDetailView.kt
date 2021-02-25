package com.sanmed.searchitems.ui.itemdetail

import com.sanmed.searchitems.ui.main.IItemView
import com.sanmed.searchitems.ui.main.ItemView

class ItemDetailView : ItemView(),IItemDetailView{


    var itemQuantity: String = ""
    var itemSellerLink: String = ""
    var itemSellerDate: String = ""
    var itemSellerReputation: String = ""
    override fun getQuantity(): String {
        return itemQuantity
    }

    override fun getSellerLink(): String {
        return itemSellerLink
    }

    override fun getSellerDate(): String {
        return itemSellerDate
    }

    override fun getSellerReputation(): String {
        return itemSellerReputation
    }
}