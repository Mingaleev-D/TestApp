package com.example.testapp.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.R

/**
 * @author : Mingaleev D
 * @data : 03.11.2023
 */

class DiscountsSliderAdapter : ListAdapter<Int, RecyclerView.ViewHolder>(DiffCall()) {

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

      private val ivWallpaper: ImageView = itemView.findViewById(R.id.slider_img)
      fun onBind(wallpaper: Int) {
         Glide.with(ivWallpaper).load(wallpaper).into(ivWallpaper)
      }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      return ViewHolder(
          LayoutInflater
              .from(parent.context)
              .inflate(R.layout.slider_adapter, parent, false)
      )
   }

   override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      val item = getItem(position)
      val hold = holder as ViewHolder
      hold.onBind(item)
   }

   private class DiffCall : DiffUtil.ItemCallback<Int>() {

      override fun areItemsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem
      override fun areContentsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem

   }
}