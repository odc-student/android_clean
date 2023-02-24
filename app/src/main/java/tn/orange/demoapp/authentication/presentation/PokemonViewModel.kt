package tn.orange.demoapp.authentication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tn.orange.demoapp.R
import tn.orange.demoapp.authentication.domain.usecase.FetchPokemonUseCase
import tn.orange.demoapp.authentication.presentation.model.UiState
import tn.orange.demoapp.authentication.presentation.model.UiState.Failure
import tn.orange.demoapp.authentication.presentation.model.UiState.Loading
import tn.orange.demoapp.authentication.presentation.model.UiState.Success
import tn.orange.demoapp.authentication.ui.model.PokemonUiModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val fetchPokemon: FetchPokemonUseCase
) : ViewModel() {

    private var _uiState = MutableLiveData<UiState>(Loading)
    val uiState: LiveData<UiState>
        get() = _uiState

    fun fetchPokemons() = viewModelScope.launch {
        _uiState.value = Loading
        try {
            _uiState.value = Success(fetchPokemon.fetchPokemons().map {
                PokemonUiModel(
                    name = it.name,
                    imageUrl = it.imageUrl,
                    variation = it.variation,
                    health = it.health,
                    defense = it.defense,
                    colorRes = R.color.black,
                    types = it.types,
                    link = it.link
                )
            })
        } catch (ex: Exception) {
            _uiState.value = Failure("Network Fail")
        }
    }
}