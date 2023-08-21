package com.example.retrofitex

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("productinsert.php")
    fun insertdata(
        @Field("product_name") p_name:String,
        @Field("product_price")  p_price:String,
        @Field("product_description")  p_des:String,

        ) : Call<Void>

    @GET("productview.php")
    fun getdata() :Call<List<Model>>


    @FormUrlEncoded
    @POST("productupdate.php")
    fun updatedata(
        @Field("product_id") product_id :Int,
        @Field("product_name") p_name:String,
        @Field("product_price")  p_price:String,
        @Field("product_description")  p_des:String,

        ) : Call<Void>

    @FormUrlEncoded
    @POST("productdelete.php")
    fun deletedata(@Field("product_id") id: Int): Call<Void?>?


}