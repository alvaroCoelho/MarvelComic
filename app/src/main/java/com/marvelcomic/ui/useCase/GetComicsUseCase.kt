package com.marvelcomic.ui.useCase

import com.marvelcomic.data.model.comic.ComicModelResponse
import com.marvelcomic.di.UseCaseDispatcher
import com.marvelcomic.repository.MarvelRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(
    private val repository: MarvelRepository,
    @UseCaseDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(characterId: Int): Response<ComicModelResponse> =
        withContext(dispatcher) {
            return@withContext repository.getComics(characterId)
        }
}