package ua.oldev.graphqlcountries.continents.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.oldev.graphqlcountries.continents.domain.mappers.toListModel
import ua.oldev.graphqlcountries.continents.domain.model.ContinentListModel
import ua.oldev.graphqlcountries.continents.domain.repository.ContinentsRepository
import javax.inject.Inject

@HiltViewModel
class ContinentsListViewModel @Inject constructor(
    private val continentsRepository: ContinentsRepository
) : ViewModel() {

    val state: StateFlow<ContinentsListScreenState>
        get() = internalState.asStateFlow()

    private val internalState = MutableStateFlow(ContinentsListScreenState())

    init {
        loadContinents()
    }

    private fun loadContinents() {
        updateState(isLoading = true)
        viewModelScope.launch {
            val result = continentsRepository.getAll()
            result.fold(
                onSuccess = { continents ->
                    updateState(
                        isLoading = false,
                        continents = continents.map { continent -> continent.toListModel() }
                    )
                },
                onFailure = { throwable -> }
            )
        }
    }

    private fun updateState(
        isLoading: Boolean? = null,
        continents: List<ContinentListModel>? = null
    ) {
        internalState.update { state ->
            state.copy(
                isLoading = isLoading ?: state.isLoading,
                continents = continents ?: state.continents
            )
        }
    }
}