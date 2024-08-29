package ua.oldev.graphqlcountries.continents.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ua.oldev.graphqlcountries.R
import ua.oldev.graphqlcountries.continents.presentation.components.ContinentsList
import ua.oldev.graphqlcountries.core.presentation.components.CenteredProgressIndicator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContinentsListScreen(
    modifier: Modifier = Modifier,
    state: ContinentsListScreenState,
    onContinentSelected: (String) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.continents_title))
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when {
                state.isLoading -> CenteredProgressIndicator()
                state.continents.isNotEmpty() -> ContinentsList(
                    continents = state.continents,
                    onContinentClick = onContinentSelected
                )
            }
        }
    }
}