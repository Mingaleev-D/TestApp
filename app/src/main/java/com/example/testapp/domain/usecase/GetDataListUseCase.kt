package com.example.recipedemotask.domain.usecase

import com.example.testapp.domain.model.DataList
import com.example.testapp.domain.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 02.11.2023
 */

class GetDataListUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {

   suspend operator fun invoke(): List<DataList> {
      return withContext(Dispatchers.IO) {
         if (dataRepository.getDataList().isEmpty()) {
            val network = dataRepository.fetchDataList()
            dataRepository.insertDataList(network)
         }
         return@withContext dataRepository.getDataList()

      }
   }
}