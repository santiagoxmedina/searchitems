package com.sanmed.searchitems.ui.main

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ItemViewTest{

    lateinit var itemView: ItemView
    @Before
    fun setUp() {
        itemView = ItemView("name","id","10","link","thumbnail")
    }

    @Test
    fun testGetName() {
        Assert.assertEquals("Should be the same",itemView.getName(),"name")
    }

    @Test
    fun getId() {
        Assert.assertEquals("Should be the same",itemView.getId(),"id")
    }

    @Test
    fun getPrice() {
        Assert.assertEquals("Should be the same",itemView.getPrice(),"10")
    }

    @Test
    fun getLink() {
        Assert.assertEquals("Should be the same",itemView.getLink(),"link")
    }

    @Test
    fun getThumbnail() {
        Assert.assertEquals("Should be the same",itemView.getThumbnail(),"thumbnail")
    }


}