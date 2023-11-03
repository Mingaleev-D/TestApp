package com.example.testapp.domain.repository

import com.example.testapp.domain.model.DataList

/**
 * @author : Mingaleev D
 * @data : 02.11.2023
 */

interface DataRepository {

   suspend fun fetchDataList(): List<DataList>
   suspend fun insertDataList(dataList: List<DataList>)
   suspend fun getDataList(): List<DataList>
}