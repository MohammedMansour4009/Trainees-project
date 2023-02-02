package com.laces.app.home.presentation

import com.laces.app.home.domain.ProductModel
import com.laces.app.mvp.OccView

interface HomeView: OccView {
    fun getProduct(result:List<ProductModel>)
}