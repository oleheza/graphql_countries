package ua.oldev.graphqlcountries.countries.presentation.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.graphqlcountries.R
import ua.oldev.graphqlcountries.core.presentation.allCountries
import ua.oldev.graphqlcountries.core.presentation.components.CenteredProgressIndicator
import ua.oldev.graphqlcountries.core.presentation.theme.GraphQlCountriesTheme
import ua.oldev.graphqlcountries.countries.presentation.list.components.CountriesList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountriesListScreen(
    modifier: Modifier = Modifier,
    state: CountriesListScreenState,
    onCountrySelected: (String) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.countries_title)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
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
            onCountrySelected = {},
            onBackClick = {}
        )
    }
}