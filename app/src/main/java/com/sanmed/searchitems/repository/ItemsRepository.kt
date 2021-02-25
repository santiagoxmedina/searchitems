package com.sanmed.searchitems.repository

import androidx.lifecycle.LiveData
import com.sanmed.searchitems.datasource.IRemoteDataSource
import com.sanmed.searchitems.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.ui.main.IItemView
import javax.inject.Inject

class ItemsRepository @Inject constructor(remoteDataSource: IRemoteDataSource): IItemsRepository {

    private val mRemoteDataSource = remoteDataSource

    override fun search(query: String?) {
        mRemoteDataSource.search(query)
    }

    override fun getItemsFromSearchResult(): LiveData<List<IItemView>> {
        return mRemoteDataSource.getItemsFromSearchResult();
    }

    override fun getItemsItemDetailView(): LiveData<IItemDetailView> {
        return mRemoteDataSource.getItemsItemDetailView()
    }

    override fun loadItemDetailView(id: String) {
        mRemoteDataSource.loadItemDetail(id)
    }
}