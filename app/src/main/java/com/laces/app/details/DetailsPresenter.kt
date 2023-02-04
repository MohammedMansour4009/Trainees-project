package com.laces.app.details

import com.laces.app.data.AppRepository
import com.laces.app.mvp.OccPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsPresenter(private val productId: Int) : OccPresenter<DetailsView>() {

    private val appRepository = AppRepository()
    override fun onCreate() {
        super.onCreate()
        getDetails(productId)
    }


    private fun getDetails(productId: Int) {
        sendToView { view ->
            presenterScope.launch {
                val result = appRepository.getDetails(productId)
                withContext(Dispatchers.Main) {
                    view.getProductDetails(result)
                }
            }
        }

    }
}