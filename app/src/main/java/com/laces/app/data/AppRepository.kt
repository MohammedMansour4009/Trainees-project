package com.laces.app.data

import com.laces.app.model.ProductModel

class AppRepository {
    // required data to presenter


    suspend fun getProducts(): List<ProductModel> {
        val quotesApi = RetrofitBuilder.getInstance().create(AppDataSource::class.java)
        return quotesApi.getWrapperProduct().body()?.products!!
    }


    suspend fun getDetails(productID: Int): ProductModel {
        val quotesApi = RetrofitBuilder.getInstance().create(AppDataSource::class.java)
        return quotesApi.getDetails(productID)
    }






}