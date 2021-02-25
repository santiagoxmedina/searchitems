package com.sanmed.searchitems.view.ui.main

import com.sanmed.searchitems.view.ItemViewHelper
import org.junit.Test
import org.junit.Assert
import org.junit.Before

class ItemViewDiffTest  {

    private lateinit var itemViewDiff :ItemViewDiff

    @Before fun before(){
        itemViewDiff = ItemViewDiff()
    }

    @Test
    fun testAreItemsTheSame() {
         val itemView1 = ItemViewHelper.getItemView("n","i","10","l","img")
         val itemView2 = ItemViewHelper.getItemView("nh","i","11","lh","imgh")
        Assert.assertTrue("should be the same",itemViewDiff.areItemsTheSame(itemView1,itemView2))
    }

    @Test
    fun testAreNotItemsTheSame() {
        val itemView1 = ItemViewHelper.getItemView("n","i","10","l","img")
        val itemView2 = ItemViewHelper.getItemView("nh","i2","11","lh","imgh")
        Assert.assertFalse("should be different the same",itemViewDiff.areItemsTheSame(itemView1,itemView2))
    }


    @Test fun testAreContentsTheSame() {
        val itemView1 = ItemViewHelper.getItemView("ns","is","15","ls","imgs")
        val itemView2 = ItemViewHelper.getItemView("ns","iso","15","ls","imgs")
        Assert.assertTrue("should be the same content",itemViewDiff.areContentsTheSame(itemView1,itemView2))
    }

    @Test fun testAreContentsNotTheSame() {
        val itemView1 = ItemViewHelper.getItemView("ns","is","15","ls","imgs")
        val itemView2 = ItemViewHelper.getItemView("nso","iso","15o","lso","imgo")
        Assert.assertFalse("should be different the same content",itemViewDiff.areContentsTheSame(itemView1,itemView2))
    }


}