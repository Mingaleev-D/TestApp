package com.example.testapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.testapp.R
import com.example.testapp.data.common.Resource
import com.example.testapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
   private val viewMode: DataViewModel by viewModels()
   private val dataAdapter = DataListAdapter()
   private val discountAdapter = DiscountsSliderAdapter()

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)



      initPager()
      initReeciclerVIew()
      subscribeObservers()
      viewMode.getAllDataList()
   }

   private fun initPager() {
      binding.containerVp2.apply {
         adapter = discountAdapter
      }
      discountAdapter.submitList(getDiscounts())
   }

   private fun getDiscounts(): List<Int> {
      val data = arrayListOf<Int>()
      data.add(R.drawable.discounts1)
      data.add(R.drawable.discounts2)
      return data

   }

   private fun subscribeObservers() {
      viewMode.dataList.observe(this) { result ->
         when (result) {
            is Resource.Error -> {
               binding.progressBar.isVisible = false
               Toast
                   .makeText(this,
                             getString(R.string.an_error_has_occurred_please_try_again), Toast.LENGTH_SHORT)
                   .show()
            }

            is Resource.Loading -> {
               binding.progressBar.isVisible = true
            }

            is Resource.Success -> {
               binding.progressBar.isVisible = false
               dataAdapter.submitList(result.data)
            }
         }

      }
   }

   private fun initReeciclerVIew() {
      binding.dataRv.apply {
         adapter = dataAdapter
      }
   }
}