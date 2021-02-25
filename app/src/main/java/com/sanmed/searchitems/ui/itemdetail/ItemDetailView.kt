package com.sanmed.searchitems.ui.itemdetail

import com.sanmed.searchitems.ui.main.IItemView
import com.sanmed.searchitems.ui.main.ItemView

class ItemDetailView (itemName: String,
                      itemId: String,
                      itemPrice: String,
                      itemLink: String,
                      itemThumbnail: String): ItemView(itemName,itemId,itemPrice,itemLink,itemThumbnail),IItemDetailView{


    var itemQuantity: String = ""
    var itemSellerLink: String = ""
    var itemSellerDate: String = ""
    var itemSellerReputation: String = ""

    constructor(
        itemName: String,
        itemId: String,
        itemPrice: String,
        itemLink: String,
        itemThumbnail: String,
        itemQuantity: String,
        itemSellerLink: String,
        itemSellerDate: String,
        itemSellerReputation: String
    ) : this(itemName, itemId, itemPrice, itemLink, itemThumbnail) {
        this.itemQuantity = itemQuantity
        this.itemSellerLink = itemSellerLink
        this.itemSellerDate = itemSellerDate
        this.itemSellerReputation = itemSellerReputation
    }
    constructor():this("","","","","")


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