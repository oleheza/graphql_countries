package ua.oldev.graphqlcountries.countries.presentation.list

import androidx.compose.runtime.Immutable
import ua.oldev.graphqlcountries.countries.domain.model.CountryListModel

@Immutable
data class CountriesListScreenState(
    val isLoading: Boolean = false,
    val countries: List<CountryListModel> = emptyList()
)
