package com.sanmed.searchitems.model.repository

import androidx.lifecycle.LiveData
import com.sanmed.searchitems.model.remote.Resource
import com.sanmed.searchitems.view.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.view.ui.main.IItemView

interface IItemsRepository {
    fun search(query: String?)
    fun getItemsFromSearchResult(): LiveData<Resource<List<IItemView>>>
    fun getItemsItemDetailView(): LiveData<Resource<IItemDetailView>>
    fun loadItemDetailView(id: String)
}