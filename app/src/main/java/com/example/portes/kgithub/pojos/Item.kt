package com.example.portes.kgithub.pojos

import com.google.gson.annotations.SerializedName

/**
 * Created by portes on 03/12/17.
 */
data class Item(
            @SerializedName("id") val id: Int, //12544093
            @SerializedName("name") val name: String, //Android
            @SerializedName("full_name") val fullName: String, //hmkcode/Android
            @SerializedName("owner") val owner: Owner,
            @SerializedName("language") val language: String?,
            @SerializedName("watchers") val watchers: Int,
            @SerializedName("score") val score: Double
    )