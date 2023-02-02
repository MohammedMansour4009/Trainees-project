package com.laces.app.home.presentation

import android.view.LayoutInflater
import com.laces.app.databinding.ActivityHomeBinding
import com.laces.app.home.domain.ProductModel
import com.laces.app.home.presentation.adapter.ProductAdapter
import com.laces.app.mvp.OccActivity

class HomeActivity : OccActivity<ActivityHomeBinding, HomePresenter, HomeView>(),
    HomeView {

    override fun providePresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun provideBinding(layoutInflater: LayoutInflater): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun getProduct(result: List<ProductModel>) {
        binding.recyclerViewProducts.adapter = ProductAdapter(result)
    }
}