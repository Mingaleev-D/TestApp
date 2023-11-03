package com.example.testapp.data.remote

import com.example.testapp.data.common.Constants.END_POINT
import com.example.testapp.data.remote.model.DataListDto
import retrofit2.http.GET

/**
 * @author : Mingaleev D
 * @data : 02.11.2023
 */

interface ApiService {

   @GET(END_POINT)
   suspend fun fetchDataList():List<DataListDto>
}