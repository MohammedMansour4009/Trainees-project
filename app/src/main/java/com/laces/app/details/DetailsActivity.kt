package com.laces.app.details

import android.os.Bundle
import android.view.LayoutInflater
import com.laces.app.databinding.ActivityDetailsBinding
import com.laces.app.details.adapter.ProductDetailsImagesAdapter
import com.laces.app.model.ProductModel
import com.laces.app.mvp.OccActivity

class DetailsActivity : OccActivity<ActivityDetailsBinding, DetailsPresenter, DetailsView>(),
    DetailsView {

    override fun providePresenter(): DetailsPresenter {
        val productID:Int =intent.getIntExtra("id",-1)
        return DetailsPresenter(productID)
    }

    override fun provideBinding(layoutInflater: LayoutInflater): ActivityDetailsBinding {
        return ActivityDetailsBinding.inflate(layoutInflater)
    }


    override fun getProductDetails(result: ProductModel) {
        binding.model = result
        initViewPagerImages(result.images)
    }

    private fun initViewPagerImages(images: List<String>) {
        val productImagesAdapter = ProductDetailsImagesAdapter({})
        productImagesAdapter.submitList(images)
        binding.viewPagerImages.adapter = productImagesAdapter
        binding.indicatorViewImages.attachTo(binding.viewPagerImages)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.toolbar.buttonBack.setOnClickListener {
            onBackPressed()
        }

    }

}