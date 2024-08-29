package ua.oldev.graphqlcountries.countries.presentation.details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.oldev.graphqlcountries.core.presentation.theme.GraphQlCountriesTheme
import ua.oldev.graphqlcountries.core.presentation.ukraine

@Composable
fun CountryDetailsTitle(
    modifier: Modifier = Modifier,
    name: String,
    emoji: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = emoji)
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = name
        )
    }
}

@Preview
@Composable
private fun CountryDetailsTitlePreview() {
    GraphQlCountriesTheme {
        CountryDetailsTitle(
            name = ukraine.name,
            emoji = ukraine.emoji
        )
    }
}