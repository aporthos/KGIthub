package com.example.portes.kgithub.pojos
import com.google.gson.annotations.SerializedName


/**
 * Created by portes on 03/12/17.
 */
data class Base<T>(@SerializedName("total_count") val totalCount: Int, //607038
                @SerializedName("incomplete_results") val incompleteResults: Boolean, //false
                @SerializedName("items") val items: ArrayList<Item>)

