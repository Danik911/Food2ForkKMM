package com.example.food2forkkmm.datasource.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class RecipeSearchResponse(

    @SerialName("count")
    var longDateUpdated: Int,

    @SerialName("results")
    var results: List<RecipeDto>,
)
