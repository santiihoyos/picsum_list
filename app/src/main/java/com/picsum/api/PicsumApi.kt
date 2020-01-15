package com.picsum.api

import com.picsum.api.model.FileItemDto
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PicsumApi {

    companion object {
        const val baseUrl = "https://picsum.photos/"

        private lateinit var instan: PicsumApi

        fun getInstance() = if (!::instan.isInitialized) {
            instan = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl).build()
                .create(PicsumApi::class.java)
            instan
        } else {
            instan
        }
    }

    @GET("list")
    fun getFileList(): Call<List<FileItemDto>>
}

fun getPicsumImageUrlWithDimens(imageId: String, height: Int, width: Int): String {
    return PicsumApi.baseUrl.plus("id/$imageId/$height/$width")
}