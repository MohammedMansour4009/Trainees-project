package com.laces.app.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import com.laces.app.databinding.ActivityHomeBinding
import com.laces.app.details.DetailsActivity
import com.laces.app.model.ProductModel
import com.laces.app.mvp.OccActivity

class HomeActivity : OccActivity<ActivityHomeBinding, HomePresenter, HomeView>(),
    HomeView {

    override fun providePresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun provideBinding(layoutInflater: LayoutInflater): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }


    override fun setRecyclerData(result: List<ProductModel>) {
        //Log.d("LOG00",result.toString())
        binding.recyclerViewProducts.adapter = HomeAdapter(result, ::goToProductDeciteslas)
    }

    override fun setLoading(isLoading: Boolean) {
        binding.progress.isVisible = isLoading
    }

    override fun setError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun goToProductDeciteslas(id: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.observeProducts(this)
    }


}