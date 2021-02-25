package com.sanmed.searchitems.ui.main

open class ItemView : IItemView {
    var itemName: String = ""
    var itemId: String = ""
    var itemPrice: String = ""
    var itemLink: String = ""
    var itemThumbnail: String = ""

    override fun getName(): String {
        return itemName
    }

    override fun getId(): String {
        return itemId
    }

    override fun getPrice(): String {
        return itemPrice
    }

    override fun getLink(): String {
        return itemLink
    }

    override fun getThumbnail(): String {
        return itemThumbnail
    }
}