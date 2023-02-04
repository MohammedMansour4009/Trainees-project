package com.laces.app.data


import com.laces.app.model.ProductModel
import com.laces.app.model.WrapperProduct
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AppDataSource {

    @GET("/products")
    suspend fun getWrapperProduct(): Response<WrapperProduct>


    @GET("/products/{id}")
    suspend fun getDetails(@Path("id") id: Int): ProductModel //Response
}