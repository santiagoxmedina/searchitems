package com.sanmed.searchitems.ui.main

class ItemView:IItemView {
    lateinit var itemName: String
    override fun getName(): String {
        return itemName
    }
}