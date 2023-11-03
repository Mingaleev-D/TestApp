package com.example.testapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataEntity(
    @PrimaryKey
    val id: String,
    val image: String,
    val name: String,
    val description: String,
)
