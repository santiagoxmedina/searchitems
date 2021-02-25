package com.sanmed.searchitems.view

import com.sanmed.searchitems.model.dto.MercadoLibreItemDTO
import com.sanmed.searchitems.model.entity.Item
import com.sanmed.searchitems.view.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.view.ui.itemdetail.ItemDetailView
import com.sanmed.searchitems.view.ui.main.IItemView
import com.sanmed.searchitems.view.ui.main.ItemView
import com.sanmed.searchitems.model.utilities.CurrencyUtilities

class ItemViewHelper {

    companion object {
        fun parseIItemViewFromMercadoLibreItem(itemDTO: MercadoLibreItemDTO): IItemView {
            val result = ItemView()
            itemDTO.title?.let {
                result.itemName = it
            }
            itemDTO.id?.let {
                result.itemId = it
            }
            itemDTO.price?.let {
                result.itemPrice = CurrencyUtilities.getCurrencyFormat(it)
            }
            itemDTO.permalink?.let {
                result.itemLink = it
            }
            itemDTO.thumbnail?.let {
                result.itemThumbnail = it
            }
            return result
        }

        fun parseIItemDetailViewFromMercadoLibreItem(itemDTO: MercadoLibreItemDTO): IItemDetailView {
            val result = ItemDetailView()
            itemDTO.title?.let {
                result.itemName = it
            }
            itemDTO.id?.let {
                result.itemId = it
            }
            itemDTO.price?.let {
                result.itemPrice = CurrencyUtilities.getCurrencyFormat(it)
            }
            itemDTO.permalink?.let {
                result.itemLink = it
            }
            itemDTO.thumbnail?.let {
                result.itemThumbnail = it
            }
            itemDTO.available_quantity?.let {
                result.itemQuantity = it.toString()
            }
            itemDTO.sellerDTO?.let { seller ->
                seller.permalink?.let {
                    result.itemSellerLink = it
                }
                seller.registrationDate?.let {
                    result.itemSellerDate = it
                }
                seller.sellerReputationDTO?.let { seller_reputation ->
                    seller_reputation.powerSellerStatus?.let {
                        result.itemSellerReputation = it
                    }
                }
            }
            return result
        }

        fun getItemView(
            itemName: String,
            itemId: String,
            itemPrice: String,
            itemLink: String,
            itemThumbnail: String
        ): IItemView {
            return object : IItemView {

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

        fun parseIItemViewFromItem(item: Item): IItemView {
            val result = ItemView()
            item.itemName?.let {
                result.itemName = it
            }
            item.itemId?.let {
                result.itemId = it
            }
            item.itemPrice?.let {
                result.itemPrice = it
            }
            item.itemLink?.let {
                result.itemLink = it
            }
            item.itemThumbnail?.let {
                result.itemThumbnail = it
            }
            return result
        }
    }

}