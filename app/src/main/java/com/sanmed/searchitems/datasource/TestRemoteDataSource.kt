package com.sanmed.searchitems.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sanmed.searchitems.ui.main.IItemView
import com.sanmed.searchitems.ui.main.ItemView
import javax.inject.Inject

class TestRemoteDataSource @Inject constructor():IRemoteDataSource {

    private val testItems = MutableLiveData<List<IItemView>>()
    private val resultItems = MutableLiveData<List<IItemView>>()

    init {
        testItems.value = createTestItems()
    }

    private fun createTestItems(): List<IItemView> {
        val result = mutableListOf<IItemView>()
        var temp: ItemView;
        for(i in 1..10){
            temp = ItemView()
            temp.itemName = i.toString()
            result.add(temp)
        }

        return result
    }

    override fun search(query: String?) {
        query?.let {
            resultItems.value = filterItems(query,testItems)
        }
    }

    private fun filterItems(
        query: String,
        testItems: MutableLiveData<List<IItemView>>
    ): List<IItemView>? {
        val result = mutableListOf<IItemView>()
        testItems.value?.let {
            for (item in it) {
                if(item.getName().contains(query)){
                    result.add(item)
                }
            }
        }
       return result
    }

    override fun getItemsFromSearchResult(): LiveData<List<IItemView>> {
        return resultItems
    }
}