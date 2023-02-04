package com.laces.app.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.laces.app.databinding.RowProductDetailsImageBinding

class ProductDetailsImagesAdapter(
    private val onItemClick: (positions: Int) -> Unit
) : ListAdapter<String, ProductDetailsImagesAdapter.ViewHolder>(DiffCallback) {

    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        layoutInflater = LayoutInflater.from(recyclerView.context)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductDetailsImagesAdapter.ViewHolder {
        return ViewHolder(RowProductDetailsImageBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ProductDetailsImagesAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: RowProductDetailsImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(url: String) {
            binding.url = url
            itemView.setOnClickListener {
                onItemClick(layoutPosition)
            }
            binding.executePendingBindings()
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

}