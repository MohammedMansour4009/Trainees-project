package com.laces.app.details

import com.laces.app.mvp.OccView
import com.laces.app.sdk.model.ProductModel

interface DetailsView: OccView {
   fun getProductDetails(result: ProductModel)
}