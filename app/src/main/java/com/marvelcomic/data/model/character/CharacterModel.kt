package com.marvelcomic.data.model.character

import com.google.gson.annotations.SerializedName
import com.marvelcomic.data.model.ThumbnailModel
import java.io.Serializable

data class CharacterModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("thumbnail")
    val thumbnailModel: ThumbnailModel

) : Serializable