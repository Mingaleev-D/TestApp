package com.example.testapp.data.remote.model


import com.google.gson.annotations.SerializedName

data class DataListDto(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("image")
    val image: String = "",
    @SerializedName("name")
    val name: String = "",

)