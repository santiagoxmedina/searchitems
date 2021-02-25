package com.sanmed.searchitems.view.ui.main

open class ItemView (): IItemView {
    var itemName: String = ""
    var itemId: String = ""
    var itemPrice: String = ""
    var itemLink: String = ""
    var itemThumbnail: String = ""

    constructor(
        itemName: String,
        itemId: String,
        itemPrice: String,
        itemLink: String,
        itemThumbnail: String
    ) : this() {
        this.itemName = itemName
        this.itemId = itemId
        this.itemPrice = itemPrice
        this.itemLink = itemLink
        this.itemThumbnail = itemThumbnail
    }




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