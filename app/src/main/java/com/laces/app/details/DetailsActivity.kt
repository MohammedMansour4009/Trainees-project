package com.laces.app.details

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import com.laces.app.databinding.ActivityDetailsBinding
import com.laces.app.details.adapter.ProductDetailsImagesAdapter
import com.laces.app.mvp.BaseActivity
import com.laces.app.sdk.model.ProductModel

class DetailsActivity : BaseActivity<ActivityDetailsBinding, DetailsPresenter, DetailsView>(),
    DetailsView {

    override fun providePresenter(): DetailsPresenter {
        val productID: Int = intent.getIntExtra("id", -1)
        return DetailsPresenter(productID)
    }

    override fun provideBinding(layoutInflater: LayoutInflater): ActivityDetailsBinding {
        return ActivityDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.observeProducts(this)
        binding.toolbar.buttonBack.setOnClickListener {
            onBackPressed()
        }
        handleViews()
    }

    override fun getProductDetails(result: ProductModel) {
        binding.model = result
        binding.toolbar.textViewTitle.text = result.category
        initViewPagerImages(result.images)
    }

    private fun handleViews() {
        binding.layoutProductDescription.setOnClickListener {
            binding.showDescription = binding.showDescription == false
        }
    }

    private fun initViewPagerImages(images: List<String>) {
        val productImagesAdapter = ProductDetailsImagesAdapter({})
        productImagesAdapter.submitList(images)
        binding.viewPagerImages.adapter = productImagesAdapter
        binding.indicatorViewImages.attachTo(binding.viewPagerImages)

    }

    override fun setLoading(isLoading: Boolean) {
        binding.progressBarDetail.isVisible = isLoading
    }

    override fun setError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}