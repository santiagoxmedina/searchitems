package com.sanmed.searchitems.model.datasource

import androidx.lifecycle.LiveData
import com.sanmed.searchitems.model.remote.Resource
import com.sanmed.searchitems.view.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.view.ui.main.IItemView

interface IRemoteDataSource {
    fun search(query: String?)
    fun getItemsFromSearchResult(): LiveData<Resource<List<IItemDetailView>>>
    fun getItemsItemDetailView(): LiveData<Resource<IItemDetailView>>
    fun loadItemDetail(id: String)
}