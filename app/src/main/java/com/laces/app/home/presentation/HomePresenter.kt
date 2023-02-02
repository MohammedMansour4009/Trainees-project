package com.laces.app.home.presentation

import com.laces.app.home.data.HomeRepository
import com.laces.app.mvp.OccPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomePresenter : OccPresenter<HomeView>() {

    private var homeRepository = HomeRepository()

    override fun onCreate() {
        super.onCreate()
        getProducts()
    }

    private fun getProducts() {
        sendToView { view ->
            presenterScope.launch {
                withContext(Dispatchers.Main){
                    val result = homeRepository.getProducts()
                    view.getProduct(result)
                }
            }
        }


    }


}