package ua.oldev.graphqlcountries.continents.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.graphqlcountries.R
import ua.oldev.graphqlcountries.continents.domain.model.ContinentListModel
import ua.oldev.graphqlcountries.core.presentation.europe
import ua.oldev.graphqlcountries.core.presentation.theme.GraphQlCountriesTheme

@Composable
fun ContinentListItem(
    modifier: Modifier = Modifier,
    continent: ContinentListModel
) {
    ListItem(
        modifier = modifier,
        headlineContent = { Text(text = continent.name) },
        leadingContent = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_location_pin_24),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = "Location"
            )
        }
    )
}

@Preview
@Composable
private fun ContinentListItemPreview() {
    GraphQlCountriesTheme {
        ContinentListItem(continent = europe)
    }
}