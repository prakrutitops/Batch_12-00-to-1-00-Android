package com.example.retrofitex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Model
{
    @Expose
    @SerializedName("product_id")
    var id = 0

    @Expose
    @SerializedName("product_name")
    var p_name: String? = null

    @Expose
    @SerializedName("product_price")
    var p_price: String? = null

    @Expose
    @SerializedName("product_description")
    var p_des: String? = null
}