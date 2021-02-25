package com.sanmed.searchitems.repository

import androidx.lifecycle.LiveData
import com.sanmed.searchitems.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.ui.main.IItemView

interface IItemsRepository {
    fun search(query: String?)
    fun getItemsFromSearchResult(): LiveData<List<IItemView>>
    fun getItemsItemDetailView(): LiveData<IItemDetailView>
    fun loadItemDetailView(id: String)
}