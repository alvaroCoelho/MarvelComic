package com.marvelcomic.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvelcomic.data.model.comic.ComicModel
import com.marvelcomic.data.model.comic.ComicModelResponse
import com.marvelcomic.ui.useCase.GetComicsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CharacterComicsListViewModel @Inject constructor(
    private val getComicsUseCase: GetComicsUseCase
) : ViewModel() {
    private val _list: MutableState<ResourceState> = mutableStateOf(ResourceState.Loading)
    val list: State<ResourceState> = _list


    fun fetch(characterId: Int) = viewModelScope.launch {
        searchComics(characterId)
    }

    private suspend fun searchComics(characterId: Int) {

        try {
            val response = getComicsUseCase.invoke(characterId)
            _list.value = handleResponse(response)

        } catch (t: Throwable) {
            when (t) {
                is IOException -> _list.value = ResourceState.Error("Conection error")
                else -> _list.value = ResourceState.Error("data error")
            }
        }

    }

    private fun handleResponse(response: Response<ComicModelResponse>): ResourceState {
        if (response.isSuccessful) {
            response.body()?.let { values ->
                return ResourceState.Success(values.data.result)
            }
        }
        return ResourceState.Error(response.message())
    }

}


sealed interface ResourceState {
    object Loading : ResourceState
    class Success(
        val allComics: List<ComicModel>
    ) : ResourceState

    class Error(
        val Message: String
    ) : ResourceState

    object Empty : ResourceState
}
