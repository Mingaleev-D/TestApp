package com.example.testapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author : Mingaleev D
 * @data : 02.11.2023
 */

@Database(entities = [DataEntity::class], version = 1)
abstract class DataDatabase: RoomDatabase() {

   abstract fun dataDao(): DataDao
}