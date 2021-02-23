package com.sanmed.searchitems.datasource

import androidx.lifecycle.LiveData
import com.sanmed.searchitems.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.ui.main.IItemView

interface IRemoteDataSource {
    fun search(query: String?)
    fun getItemsFromSearchResult(): LiveData<List<IItemView>>
    fun getItemsItemDetailView(): LiveData<IItemDetailView>
    fun loadItemDetail(id: Long)
}