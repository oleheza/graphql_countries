package ua.oldev.graphqlcountries.countries.presentation.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.graphqlcountries.core.presentation.allCountries
import ua.oldev.graphqlcountries.core.presentation.theme.GraphQlCountriesTheme
import ua.oldev.graphqlcountries.countries.domain.model.CountryListModel

@Composable
fun CountriesList(
    modifier: Modifier = Modifier,
    countries: List<CountryListModel>,
    onCountrySelected: (String) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(
            countries,
            key = { country -> country.code }
        ) { country ->
            CountriesListItem(
                modifier = Modifier.clickable { onCountrySelected.invoke(country.code) },
                country = country
            )
            HorizontalDivider()
        }
    }
}

@Preview
@Composable
private fun CountriesListPreview() {
    GraphQlCountriesTheme {
        CountriesList(
            countries = allCountries,
            onCountrySelected = {}
        )
    }
}