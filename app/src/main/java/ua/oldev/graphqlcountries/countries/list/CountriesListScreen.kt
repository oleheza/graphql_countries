package ua.oldev.graphqlcountries.countries.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.graphqlcountries.core.presentation.allCountries
import ua.oldev.graphqlcountries.core.presentation.components.CenteredProgressIndicator
import ua.oldev.graphqlcountries.core.presentation.theme.GraphQlCountriesTheme
import ua.oldev.graphqlcountries.countries.list.components.CountriesList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountriesListScreen(
    modifier: Modifier = Modifier,
    state: CountriesListScreenState,
    onCountrySelected: (String) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Countries") }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when {
                state.isLoading -> CenteredProgressIndicator()
                state.countries.isNotEmpty() -> CountriesList(
                    countries = state.countries,
                    onCountrySelected = onCountrySelected
                )
            }
        }
    }
}

@Preview
@Composable
private fun CountriesListScreenPreview() {
    GraphQlCountriesTheme {
        CountriesListScreen(
            state = CountriesListScreenState(countries = allCountries),
            onCountrySelected = {}
        )
    }
}