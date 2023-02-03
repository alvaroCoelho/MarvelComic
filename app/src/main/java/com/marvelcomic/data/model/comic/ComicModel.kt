package com.marvelcomic.data.model.comic

import com.marvelcomic.data.model.ThumbnailModel
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ComicModel(
    @SerializedName("id")
    val id:Int,
    @SerializedName("title")
    val title:String,
    @SerializedName("descrition")
    val descrition:String,
    @SerializedName("thumbnail")
    val thumbnailModel: ThumbnailModel
):Serializable
