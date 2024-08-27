package ua.oldev.graphqlcountries.countries.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.oldev.graphqlcountries.core.data.repository.CountriesRepository
import ua.oldev.graphqlcountries.core.domain.mappers.mapToListModel
import ua.oldev.graphqlcountries.core.domain.model.CountryListModel
import javax.inject.Inject

@HiltViewModel
class CountriesListViewModel @Inject constructor(
    private val countriesRepository: CountriesRepository
) : ViewModel() {

    val state: StateFlow<CountriesListScreenState>
        get() = internalState.asStateFlow()

    private val internalState = MutableStateFlow(CountriesListScreenState())

    init {
        loadCountries()
    }

    private fun loadCountries() {

        updateState(isLoading = true)

        viewModelScope.launch {
            val result = countriesRepository.getAll()

            result.fold(
                onSuccess = { countries ->
                    updateState(
                        isLoading = false,
                        countries = countries.map { country -> country.mapToListModel() }
                    )
                },
                onFailure = { throwable ->

                }
            )
        }
    }

    private fun updateState(
        isLoading: Boolean? = null,
        countries: List<CountryListModel>? = null
    ) {
        internalState.update { state ->
            state.copy(
                isLoading = isLoading ?: state.isLoading,
                countries = countries ?: state.countries
            )
        }
    }
}
