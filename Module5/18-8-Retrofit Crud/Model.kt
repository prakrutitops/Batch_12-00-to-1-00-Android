package com.example.retrofitex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Model
{
    @Expose
    @SerializedName("id")
    var id = 0

    @Expose
    @SerializedName("p_name")
    var p_name: String? = null

    @Expose
    @SerializedName("p_price")
    var p_price: String? = null

    @Expose
    @SerializedName("p_des")
    var p_des: String? = null
}