package com.laces.app.home.data

import com.laces.app.home.domain.ProductModel

class HomeRepository {

    suspend fun getProducts(): List<ProductModel> {
        val quotesApi = RetrofitHelper.getInstance().create(HomeDataSources::class.java)
        return quotesApi.getProduct().body()?.products as ArrayList<ProductModel>
    }
}