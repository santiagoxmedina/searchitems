package com.sanmed.searchitems.model.datasource

import androidx.lifecycle.LiveData
import com.sanmed.searchitems.model.remote.Resource
import com.sanmed.searchitems.view.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.view.ui.main.IItemView

interface ILocalDataSource {
    fun getItemsFromSearchResult(): LiveData<List<IItemView>>
    fun getItemsItemDetailView(): LiveData<IItemDetailView>
    fun replace(newData: List<IItemDetailView>)
    fun loadItemDetail(id: String)
}