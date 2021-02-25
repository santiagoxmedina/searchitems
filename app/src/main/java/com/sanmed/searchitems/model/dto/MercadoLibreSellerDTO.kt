package com.sanmed.searchitems.model.dto

import com.google.gson.annotations.SerializedName

class MercadoLibreSellerDTO {
    @SerializedName("id")
    var id:String? = ""
    @SerializedName("permalink")
    var permalink:String? = ""
    @SerializedName("registration_date")
    var registrationDate:String? = ""
    @SerializedName("seller_reputation")
    var sellerReputationDTO: MercadoLibreSellerReputationDTO? = MercadoLibreSellerReputationDTO()
}