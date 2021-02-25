package com.sanmed.searchitems.model.datasource

import androidx.lifecycle.*
import com.sanmed.searchitems.view.ItemViewHelper
import com.sanmed.searchitems.model.dao.ItemDao
import com.sanmed.searchitems.model.entity.Item
import com.sanmed.searchitems.view.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.view.ui.itemdetail.ItemDetailView
import com.sanmed.searchitems.view.ui.main.IItemView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalDataSource @Inject constructor(itemDao: ItemDao) : ILocalDataSource {
    private val mItemDao = itemDao
    private val allItems: Flow<List<Item>> = itemDao.getAll()
    private val itemId = MutableLiveData<String>()

    override fun getItemsFromSearchResult(): LiveData<List<IItemView>> {
        return Transformations.map(allItems.asLiveData(), this::parseIItemViewFromItem);
    }

    override fun getItemsItemDetailView(): LiveData<IItemDetailView> {
        return Transformations.switchMap(itemId,this::loadItem)
    }

    private fun loadItem(id: String?): LiveData<IItemDetailView> {
        var result = ""
        id?.let {
            result = it
        }
        return Transformations.map(mItemDao.loadByIds(result),this::parseIItemViewDetailFromItem)
    }

    override fun replace(newData: List<IItemDetailView>) {
        GlobalScope.launch {
            mItemDao.replace(parseItemFromIItemView(newData))
        }
    }

    override fun loadItemDetail(id: String) {
        itemId.value = id
    }

    private fun parseItemFromIItemView(items: List<IItemDetailView>?): List<Item> {
        val result = mutableListOf<Item>()
        items?.forEach {
            result.add(
                Item(
                    it.getId(),
                    it.getName(),
                    it.getPrice(),
                    it.getLink(),
                    it.getThumbnail(),
                    it.getQuantity(),
                    it.getSellerLink(),
                    it.getSellerDate(),
                    it.getSellerReputation()
                )
            )
        }
        return result;
    }

    private fun parseIItemViewDetailFromItem(item: Item): IItemDetailView {
        return ItemDetailView(
            item.itemName,
            item.itemId,
            item.itemPrice,
            item.itemLink,
            item.itemThumbnail,
            item.itemQuantity,
            item.itemSellerLink,
            item.itemSellerDate,
            item.itemSellerReputation
        );
    }

    private fun parseIItemViewFromItem(items: List<Item>?): List<IItemView> {
        val result = mutableListOf<IItemView>()
        items?.forEach {
            result.add(ItemViewHelper.parseIItemViewFromItem(it))
        }
        return result;
    }
}