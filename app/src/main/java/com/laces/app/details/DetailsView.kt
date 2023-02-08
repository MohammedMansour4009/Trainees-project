package com.laces.app.details

import com.laces.app.sdk.model.ProductModel

interface DetailsView: OccView {
   fun getProductDetails(result: ProductModel)

   fun setLoading(isLoading: Boolean)

   fun setError(message: String)


}
