package com.laces.app.details

import com.laces.app.model.ProductModel
import com.laces.app.mvp.OccView

interface DetailsView: OccView {
   fun getProductDetails(result: ProductModel)
}