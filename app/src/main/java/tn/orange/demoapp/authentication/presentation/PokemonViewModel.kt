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
import tn.orange.demoapp.authentication.ui.model.PokemonUiModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val fetchPokemon: FetchPokemonUseCase
) : ViewModel() {

    private var _uiState = MutableLiveData<UiState>(UiState.Loading)
    val uiState: LiveData<UiState>
        get() = _uiState

    fun fetchPokemons() = viewModelScope.launch {
        _uiState.value = UiState.Loading
        try {
            _uiState.value = UiState.Success(fetchPokemon.fetchPokemons().map {
                PokemonUiModel(
                    it.name,
                    it.imageUrl,
                    it.variation,
                    R.color.black
                )
            })
        } catch (ex: Exception) {
            _uiState.value = UiState.Failure("Network Fail")
        }
    }
}