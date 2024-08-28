package ua.oldev.graphqlcountries.continents.presentation

import androidx.compose.runtime.Immutable
import ua.oldev.graphqlcountries.continents.domain.model.ContinentListModel

@Immutable
data class ContinentsListScreenState(
    val isLoading: Boolean = false,
    val continents: List<ContinentListModel> = emptyList()
)
