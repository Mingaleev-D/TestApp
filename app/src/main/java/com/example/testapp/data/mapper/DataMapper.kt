package com.example.testapp.data.mapper

import com.example.testapp.data.local.DataEntity
import com.example.testapp.data.remote.model.DataListDto
import com.example.testapp.domain.model.DataList

/**
 * @author : Mingaleev D
 * @data : 02.11.2023
 */

fun DataListDto.mapToDomain(): DataList {
   return DataList(
       description = this.description ?: "",
       id = this.id ?: "",
       image = this.image ?: "",
       name = this.name ?: "",
   )
}

fun DataListDto.mapToEntity(): DataEntity {
   return DataEntity(
       description = this.description ?: "",
       id = this.id ?: "",
       image = this.image ?: "",
       name = this.name ?: "",
   )
}

fun DataEntity.mapToDomain(): DataList {
   return DataList(
       description = this.description ?: "",
       id = this.id ?: "",
       image = this.image ?: "",
       name = this.name ?: "",
   )
}

fun DataList.mapToEntity(): DataEntity {
   return DataEntity(
       description = this.description ?: "",
       id = this.id ?: "",
       image = this.image ?: "",
       name = this.name ?: "",
   )
}