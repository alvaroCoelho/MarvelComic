package com.marvelcomic.data.remote

import com.marvelcomic.data.model.comic.ComicModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {

    @GET("characters/{characterId}/comics")
    suspend fun getComics(
        @Path(
            value = "characterId",
            encoded = true
        ) characterId: Int

    ): Response<ComicModelResponse>
}