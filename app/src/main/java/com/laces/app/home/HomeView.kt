package com.laces.app.home

import com.laces.app.model.ProductModel
import com.laces.app.mvp.OccView

interface HomeView : OccView {
    fun setRecyclerData(result: List<ProductModel>)
    fun setLoading(isLoading: Boolean)

    fun setError(message: String)
}