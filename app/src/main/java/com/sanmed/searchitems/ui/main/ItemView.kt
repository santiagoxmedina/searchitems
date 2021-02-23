package com.sanmed.searchitems.ui.main

open class ItemView:IItemView {
    lateinit var itemName: String
     var itemId: Long = -1L

    override fun getName(): String {
        return itemName
    }

    override fun getId(): Long {
        return itemId
    }
}