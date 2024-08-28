package ua.oldev.graphqlcountries.countries.presentation.details

import androidx.compose.runtime.Immutable
import ua.oldev.graphqlcountries.countries.domain.model.CountryDetailsModel

@Immutable
data class CountryDetailsScreenState(
    val isLoading: Boolean = false,
    val country: CountryDetailsModel? = null
)
