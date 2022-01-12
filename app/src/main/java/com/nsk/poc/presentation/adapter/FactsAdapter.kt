package com.nsk.poc.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.nsk.poc.data.model.Row
import com.nsk.poc.databinding.LayoutFactsAdapterBinding

/**
 * Adapter class for Facts recyclerview. Uses DiffUtil to comapare two lists.
 */
class FactsAdapter : RecyclerView.Adapter<FactsAdapter.ViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Row>() {
        override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutFactsAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row = differ.currentList[position]
        holder.bind(row)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(
        private val binding: LayoutFactsAdapterBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(row: Row?) {
            binding.descriptionTv.text = row?.description
            binding.titleTv.text = row?.title
            if(row?.imageHref?.isNotEmpty() == true) {
                Glide.with(binding.root.context)
                    .load(row.imageHref)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.imageView)
            } else
                binding.imageView.visibility = View.GONE
        }
    }
}