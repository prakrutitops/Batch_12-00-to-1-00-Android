package com.example.retrofitcrudex

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("register.php")
    fun register(@Field("firstname") firstname: String?,
                   @Field("lastname") lastname: String?,
                   @Field("mobile") mobile: String?,
                   @Field("email") email: String?,
                   @Field("password") password: String?): Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun logindata(
        @Field("mobile") mobile: String?,
        @Field("password") password: String?
    ):Call<Model>

}