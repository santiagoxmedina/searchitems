package com.sanmed.searchitems.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sanmed.searchitems.datasource.IRemoteDataSource
import com.sanmed.searchitems.ui.main.IItemView

class TestItemRepository(remoteDataSource:IRemoteDataSource):IItemsRepository {


    private val mRemoteDataSource = remoteDataSource

    override fun search(query: String?) {
        mRemoteDataSource.search(query)
    }

    override fun getItemsFromSearchResult(): LiveData<List<IItemView>> {
        return mRemoteDataSource.getItemsFromSearchResult();
    }
}