package com.laces.app.home.presentation.adapter

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.laces.app.databinding.RowProductBinding
import com.laces.app.home.domain.ProductModel

class ProductAdapter(private val productList: List<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        layoutInflater = LayoutInflater.from(recyclerView.context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(RowProductBinding.inflate(layoutInflater, parent, false))
    }

    override fun getItemCount() = productList.size


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentModel = productList[position]
        holder.bind(currentModel)

    }

    inner class ProductViewHolder(private val binding: RowProductBinding) :
        ViewHolder(binding.root) {

    fun bind(model: ProductModel) {
            binding.model = model

            Glide.with(binding.root)
                .load(model.images[0])
                .into(binding.imageViewProduct)
        }

    }


}

