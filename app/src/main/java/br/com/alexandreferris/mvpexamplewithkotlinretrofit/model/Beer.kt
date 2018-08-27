package br.com.alexandreferris.mvpexamplewithkotlinretrofit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by alexandre on 14/08/18.
 */
data class Beer(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("abv") val abv: Double)