package com.laces.app.data.api

import com.laces.app.data.model.ProductModel
import com.laces.app.data.model.WrapperProduct
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface ProductsApi {

    @GET("/products")
    suspend fun getWrapperProduct(): Response<WrapperProduct>

    @GET("/products/{id}")
    suspend fun getDetails(@Path("id") id: Int): ProductModel //Response
}