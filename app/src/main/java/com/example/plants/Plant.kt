package com.example.plants

import java.io.Serializable

data class Plant(
    val imageId : Int,
    val title : String,
    val desc : String
) : Serializable
