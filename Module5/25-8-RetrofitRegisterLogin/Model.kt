package com.example.retrofitcrudex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Model
{
    @Expose
    @SerializedName("firstname")
    var fname=""

    @Expose
    @SerializedName("lastname")
    var lname=""

    @Expose
    @SerializedName("mobile")
    var mobile=""

    @Expose
    @SerializedName("email")
    var email=""

    @Expose
    @SerializedName("password")
    var password=""
}