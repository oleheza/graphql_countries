package ua.oldev.graphqlcountries.countries.presentation.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.graphqlcountries.R
import ua.oldev.graphqlcountries.core.presentation.theme.GraphQlCountriesTheme
import ua.oldev.graphqlcountries.core.presentation.ukraineDetailed
import ua.oldev.graphqlcountries.countries.presentation.details.components.CountryDetailsTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryDetailsScreen(
    modifier: Modifier = Modifier,
    state: CountryDetailsScreenState,
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    CountryDetailsTitle(
                        name = state.country?.name.orEmpty(),
                        emoji = state.country?.emoji.orEmpty()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = stringResource(id = R.string.details_back_button_content_description)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

        }
    }
}

@Preview
@Composable
private fun CountryDetailsScreenPreview() {
    GraphQlCountriesTheme {
        CountryDetailsScreen(
            state = CountryDetailsScreenState(country = ukraineDetailed),
            onBackClick = {}
        )
    }
}