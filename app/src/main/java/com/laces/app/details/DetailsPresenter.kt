package com.laces.app.details

import com.laces.app.mvp.OccPresenter
import com.laces.app.sdk.SdkImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsPresenter(private val productId: Int) : OccPresenter<DetailsView>() {

    private val sdk = SdkImpl()
    override fun onCreate() {
        super.onCreate()
        getDetails(productId)
    }


    private fun getDetails(productId: Int) {
        sendToView { view ->
            presenterScope.launch {
                val result = sdk.getDetails(productId)
                withContext(Dispatchers.Main) {
                    view.getProductDetails(result)
                }
            }
        }

    }
}