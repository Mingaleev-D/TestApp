package com.example.testapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * @author : Mingaleev D
 * @data : 02.11.2023
 */

@Dao
interface DataDao {

   @Query("SELECT * FROM DataEntity")
   fun getAllData(): List<DataEntity>

   @Insert
   fun insertAllData(vararg data: DataEntity)
}