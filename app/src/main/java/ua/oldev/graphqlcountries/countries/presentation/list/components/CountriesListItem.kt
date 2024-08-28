package ua.oldev.graphqlcountries.countries.presentation.list.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.oldev.graphqlcountries.core.presentation.theme.GraphQlCountriesTheme
import ua.oldev.graphqlcountries.core.presentation.ukraine
import ua.oldev.graphqlcountries.countries.domain.model.CountryListModel

@Composable
fun CountriesListItem(modifier: Modifier = Modifier, country: CountryListModel) {
    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(text = country.name)
        },
        leadingContent = {
            EmojiCircle(
                modifier = Modifier.size(40.dp),
                emoji = country.emoji,
                backgroundColor = Color.Red.copy(alpha = 0.3f)
            )
        }
    )
}

@Preview
@Composable
private fun CountriesListItemPreview() {
    GraphQlCountriesTheme {
        CountriesListItem(
            country = ukraine
        )
    }
}