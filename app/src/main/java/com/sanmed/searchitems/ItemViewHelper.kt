package com.sanmed.searchitems

import com.sanmed.searchitems.model.MercadoLibreItem
import com.sanmed.searchitems.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.ui.itemdetail.ItemDetailView
import com.sanmed.searchitems.ui.main.IItemView
import com.sanmed.searchitems.ui.main.ItemView
import com.sanmed.searchitems.utilities.CurrencyUtilities

class ItemViewHelper {

    companion object {
        fun parseIItemViewFromMercadoLibreItem(item: MercadoLibreItem): IItemView {
            val result = ItemView()
            item.title?.let {
                result.itemName = it
            }
            item.id?.let {
                result.itemId = it
            }
            item.price?.let {
                result.itemPrice = CurrencyUtilities.getCurrencyFormat(it)
            }
            item.permalink?.let {
                result.itemLink = it
            }
            item.thumbnail?.let {
                result.itemThumbnail = it
            }
            return result
        }

        fun parseIItemDetailViewFromMercadoLibreItem(item: MercadoLibreItem): IItemDetailView {
            val result = ItemDetailView()
            item.title?.let {
                result.itemName = it
            }
            item.id?.let {
                result.itemId = it
            }
            item.price?.let {
                result.itemPrice = CurrencyUtilities.getCurrencyFormat(it)
            }
            item.permalink?.let {
                result.itemLink = it
            }
            item.thumbnail?.let {
                result.itemThumbnail = it
            }
            item.available_quantity?.let {
                result.itemQuantity = it.toString()
            }
            item.seller?.let { seller ->
                seller.permalink?.let {
                    result.itemSellerLink = it
                }
                seller.registration_date?.let {
                    result.itemSellerDate = it
                }
                seller.seller_reputation?.let { seller_reputation ->
                    seller_reputation.power_seller_status?.let {
                        result.itemSellerReputation = it
                    }
                }
            }
            return result
        }

         fun getItemView(itemName:String,itemId: String,itemPrice: String,itemLink: String,itemThumbnail: String): IItemView {
            return object :IItemView{

                override fun getName(): String {
                    return itemName
                }

                override fun getId(): String {
                    return itemId
                }

                override fun getPrice(): String {
                    return itemPrice
                }

                override fun getLink(): String {
                    return itemLink
                }

                override fun getThumbnail(): String {
                    return itemThumbnail
                }

            }
        }
    }

}