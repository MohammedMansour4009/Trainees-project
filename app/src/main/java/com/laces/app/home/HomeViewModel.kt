package com.laces.app.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laces.app.sdk.SdkImpl
import com.laces.app.sdk.model.ProductModel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val sdk = SdkImpl()

    private val _successLiveData: MutableLiveData<List<ProductModel>> = MutableLiveData()
    val successLiveData: LiveData<List<ProductModel>> = MutableLiveData()

    private val _errorLiveData: MutableLiveData<Throwable> = MutableLiveData()
    val errorLiveData: LiveData<Throwable> = _errorLiveData

    private val _loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _loadingLiveData.postValue(true)
            try {
                _successLiveData.postValue(sdk.getProducts())
            } catch (e: Exception) {
                _errorLiveData.postValue(e)
            }
            _loadingLiveData.postValue(false)
        }

    }

}