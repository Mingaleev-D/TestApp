package com.example.testapp.data.repository

import android.util.Log
import com.example.testapp.data.local.DataDao
import com.example.testapp.domain.repository.DataRepository
import com.example.testapp.data.mapper.mapToDomain
import com.example.testapp.data.mapper.mapToEntity
import com.example.testapp.data.remote.ApiService
import com.example.testapp.data.remote.model.DataListDto
import com.example.testapp.domain.model.DataList
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 02.11.2023
 */

class DataListRepositoryImp @Inject constructor(
    private val api: ApiService,
    private val dao: DataDao
) : DataRepository {

   override suspend fun fetchDataList(): List<DataList> {
       return api.fetchDataList().map(DataListDto::mapToDomain)
//      return try {
//         val respose = api.fetchDataList()
//         if (respose.isEmpty()) {
//            respose.map { it.mapToDomain() } ?: emptyList()
//         } else {
//            emptyList()
//         }
//
//      } catch (ex: Exception) {
//         Log.d("repotag", "fetchDataList: ${ex.printStackTrace()}")
//         emptyList()
//      }
   }

   override suspend fun insertDataList(dataList: List<DataList>) {
      dao.insertAllData(*dataList.map { it.mapToEntity() }.toTypedArray())
   }

   override suspend fun getDataList(): List<DataList> {
      return dao.getAllData().map { it.mapToDomain() }
   }
}