package com.example.testapp.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.common.Resource
import com.example.testapp.domain.model.DataList
import com.example.recipedemotask.domain.usecase.GetDataListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 02.11.2023
 */

@HiltViewModel
class DataViewModel @Inject constructor(
    private val dataListUseCase: GetDataListUseCase
) : ViewModel() {

   private val _dataList: MutableLiveData<Resource<List<DataList>>> = MutableLiveData()
   val dataList: LiveData<Resource<List<DataList>>>
      get() = _dataList

   fun getAllDataList() {
      viewModelScope.launch() {
         _dataList.postValue(Resource.Loading())
         try {
            val response = dataListUseCase()
            _dataList.postValue(Resource.Success(response))
         }catch (ex:Exception){
            _dataList.postValue(ex.message?.let { Resource.Error(it) })
         }
      }
   }
}