package ua.oldev.graphqlcountries.continents.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ua.oldev.graphqlcountries.continents.domain.model.ContinentListModel

@Composable
fun ContinentsList(
    modifier: Modifier = Modifier,
    continents: List<ContinentListModel>,
    onContinentClick: (String) -> Unit
) {

    LazyColumn(modifier = modifier) {
        items(continents) { continent ->
            ContinentListItem(
                modifier = Modifier.clickable { onContinentClick.invoke(continent.code) },
                continent = continent
            )
            HorizontalDivider()
        }
    }
}