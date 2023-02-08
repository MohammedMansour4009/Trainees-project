package com.laces.app.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.laces.app.core.BaseActivity
import com.laces.app.data.model.ProductModel
import com.laces.app.databinding.ActivityHomeBinding
import com.laces.app.details.DetailsActivity


class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        initObserver()
    }

    override fun provideBinding(layoutInflater: LayoutInflater): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    private fun setRecyclerData(result: List<ProductModel>) {
        binding.recyclerViewProducts.adapter = HomeAdapter(result, ::goToProductDetails)
    }

    private fun setLoading(isLoading: Boolean) {
        binding.progressBarHome.isVisible = isLoading
    }

    private fun setError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    private fun goToProductDetails(id: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }


    private fun initObserver() {
        viewModel.loadingLiveData.observe(this, ::setLoading)
        viewModel.errorLiveData.observe(this, ::setError)
        viewModel.successLiveData.observe(this, ::setRecyclerData)
    }

}