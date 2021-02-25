package com.sanmed.searchitems.model

import com.google.gson.annotations.SerializedName
import com.sanmed.searchitems.datasource.MercadoLibreSeller

class MercadoLibreItem {
    @SerializedName("title")
    var title:String? = ""
    @SerializedName("id")
    var id:String? = ""
    @SerializedName("price")
    var price:Float? = 0F
    @SerializedName("permalink")
    var permalink:String? = ""
    @SerializedName("thumbnail")
    var thumbnail:String? = ""
    @SerializedName("available_quantity")
    var available_quantity:Int? = 0
    @SerializedName("seller")
    var seller: MercadoLibreSeller? = MercadoLibreSeller()
}