package com.sanmed.searchitems.view.ui.itemdetail

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ItemDetailViewTest  {

    lateinit var itemViewDetailView: ItemDetailView
    @Before
     fun setUp() {
        itemViewDetailView = ItemDetailView("name","id","10","link","img","q","sl","sd","sr")
    }

    @Test
    fun getQuantity() {
        Assert.assertEquals("Should be the same",itemViewDetailView.getQuantity(),"q")
    }

    @Test
    fun getSellerLink() {
        Assert.assertEquals("Should be the same",itemViewDetailView.getSellerLink(),"sl")
    }

    @Test
    fun getSellerDate() {
        Assert.assertEquals("Should be the same",itemViewDetailView.getSellerDate(),"sd")
    }

    @Test
    fun getSellerReputation() {
        Assert.assertEquals("Should be the same",itemViewDetailView.getSellerReputation(),"sr")
    }
}