package com.laces.app.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.laces.app.data.AppRepository
import com.laces.app.model.ProductModel
import com.laces.app.mvp.OccPresenter
import kotlinx.coroutines.launch

class HomePresenter : OccPresenter<HomeView>() {

    private val appRepository = AppRepository()
    private val _successLiveData: MutableLiveData<List<ProductModel>> = MutableLiveData()
    private val _errorLiveData: MutableLiveData<Throwable> = MutableLiveData()
    private val _loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()

    override fun onCreate() {
        super.onCreate()
        getProducts()
    }
    private fun getProducts() {
        presenterScope.launch {
            _loadingLiveData.postValue(true)
            try {
                _successLiveData.postValue(appRepository.getProducts())
            } catch (e: java.lang.Exception) {
                _errorLiveData.postValue(e)
            }
            _loadingLiveData.postValue(false)
        }

    }


    fun observeProducts(lifecycleOwner: LifecycleOwner) {
        _successLiveData.observe(lifecycleOwner, ::handleSuccess)
        _loadingLiveData.observe(lifecycleOwner, ::handleLoading)
        _errorLiveData.observe(lifecycleOwner, ::handleError)
    }

    private fun handleError(throwable: Throwable) {
        sendToView { view ->
            view.setError(throwable.message!!)
        }
    }

    private fun handleLoading(isLoading: Boolean) {
        sendToView { view ->
            view.setLoading(isLoading)
        }
    }

    private fun handleSuccess(products: List<ProductModel>) {
        sendToView { view ->
            view.setRecyclerData(products)
        }
    }

}