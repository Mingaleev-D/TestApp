package com.example.testapp.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.centerCropTransform
import com.example.testapp.R
import com.example.testapp.databinding.DataItemBinding
import com.example.testapp.domain.model.DataList

/**
 * @author : Mingaleev D
 * @data : 02.11.2023
 */

class DataListAdapter : ListAdapter<DataList, DataListAdapter.MyViewHolder>(diff) {

   inner class MyViewHolder(val binding: DataItemBinding) :
       RecyclerView.ViewHolder(binding.root) {

      fun bind(itemRecipe: DataList) {
         with(binding) {
            nameTv.text = itemRecipe.name
            descritionTv.text = itemRecipe.description

            dataImg.loadCircleImage(itemRecipe.image)
         }
      }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      return MyViewHolder(
          DataItemBinding.inflate(
              LayoutInflater.from(parent.context),
              parent,
              false
          )
      )
   }

   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val item = getItem(position) ?: return

      holder.bind(item)
   }

   private companion object {

      val diff = object : DiffUtil.ItemCallback<DataList>() {
         override fun areItemsTheSame(oldItem: DataList, newItem: DataList) =
             oldItem::class == newItem::class

         override fun areContentsTheSame(oldItem: DataList, newItem: DataList) =
             oldItem == newItem

      }
   }
}

fun ImageView.loadCircleImage(path: String?) {
   Glide.with(this.context).load(path)
       .apply(centerCropTransform().error(R.drawable.ic_error).circleCrop()).into(this)
}