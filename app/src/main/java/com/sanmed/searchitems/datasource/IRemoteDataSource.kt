package com.sanmed.searchitems.datasource

import androidx.lifecycle.LiveData
import com.sanmed.searchitems.ui.main.IItemView

interface IRemoteDataSource {
    fun search(query: String?)
    fun getItemsFromSearchResult(): LiveData<List<IItemView>>
}