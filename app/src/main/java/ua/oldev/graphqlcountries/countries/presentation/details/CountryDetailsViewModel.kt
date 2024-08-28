package ua.oldev.graphqlcountries.countries.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.oldev.graphqlcountries.core.presentation.navigation.destinations.CountryDetails.COUNTRY_CODE_KEY
import ua.oldev.graphqlcountries.countries.domain.mappers.mapToModel
import ua.oldev.graphqlcountries.countries.domain.model.CountryDetailsModel
import ua.oldev.graphqlcountries.countries.domain.repository.CountriesRepository
import javax.inject.Inject

@HiltViewModel
class CountryDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val countriesRepository: CountriesRepository
) : ViewModel() {

    private val countryCode = savedStateHandle.get<String>(COUNTRY_CODE_KEY).orEmpty()

    val state: StateFlow<CountryDetailsScreenState>
        get() = internalState.asStateFlow()

    private val internalState = MutableStateFlow(CountryDetailsScreenState())

    init {
        loadCountryDetails()
    }

    private fun loadCountryDetails() {
        updateState(isLoading = true)
        viewModelScope.launch {
            val result = countriesRepository.getByCode(countryCode)

            result.fold(
                onSuccess = { country ->
                    updateState(isLoading = false, country = country?.mapToModel())
                },
                onFailure = { throwable ->
                    updateState(isLoading = false)
                }
            )
        }
    }

    private fun updateState(isLoading: Boolean? = null, country: CountryDetailsModel? = null) {
        internalState.update { state ->
            state.copy(
                isLoading = isLoading ?: state.isLoading,
                country = country ?: state.country
            )
        }
    }
}