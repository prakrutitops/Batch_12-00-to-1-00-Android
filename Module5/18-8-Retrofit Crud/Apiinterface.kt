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
    @POST("insert.php")
    fun insertdata(
        @Field("p_name") p_name:String,
        @Field("p_price")  p_price:String,
        @Field("p_des")  p_des:String,

        ) : Call<Void>

    @GET("view.php")
    fun getdata() :Call<List<Model>>

    @FormUrlEncoded
    @POST("delete.php")
    fun deletedata(@Field("id") id: Int): Call<Model?>?


}