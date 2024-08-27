package ua.oldev.graphqlcountries.countries.list

import androidx.compose.runtime.Immutable
import ua.oldev.graphqlcountries.core.domain.model.CountryListModel

@Immutable
data class CountriesListScreenState(
    val isLoading: Boolean = false,
    val countries: List<CountryListModel> = emptyList()
)
