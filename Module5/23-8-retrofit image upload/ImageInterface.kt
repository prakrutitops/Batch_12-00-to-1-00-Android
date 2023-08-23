package com.example.test2

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ImageInterface {
    @FormUrlEncoded
    @POST("upload.php")
    fun getUserLogin(
        @Field("name") name: String?,
        @Field("url") url: String?

    ): Call<String?>?

    companion object {
        const val IMAGEURL = "https://vyasprakruti.000webhostapp.com/serverimage/"
    }
}