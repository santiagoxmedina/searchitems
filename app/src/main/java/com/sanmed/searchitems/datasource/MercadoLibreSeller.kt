package com.sanmed.searchitems.datasource

import com.google.gson.annotations.SerializedName

class MercadoLibreSeller {
    @SerializedName("id")
    var id:String? = ""
    @SerializedName("permalink")
    var permalink:String? = ""
    @SerializedName("registration_date")
    var registration_date:String? = ""
    @SerializedName("seller_reputation")
    var seller_reputation:MercadoLibreSellerReputation? = MercadoLibreSellerReputation()
}