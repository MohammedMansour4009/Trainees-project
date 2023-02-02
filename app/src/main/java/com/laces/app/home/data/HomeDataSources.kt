package com.laces.app.home.data

import com.laces.app.home.domain.ProductsWrapper
import retrofit2.Response
import retrofit2.http.GET

interface HomeDataSources {

    @GET("/products")
    suspend fun getProduct() : Response<ProductsWrapper>

}