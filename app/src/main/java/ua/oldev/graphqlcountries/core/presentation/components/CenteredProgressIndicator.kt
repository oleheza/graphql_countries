package ua.oldev.graphqlcountries.core.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.graphqlcountries.core.presentation.theme.GraphQlCountriesTheme

@Composable
fun CenteredProgressIndicator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
private fun CenteredProgressIndicatorPreview() {
    GraphQlCountriesTheme {
        CenteredProgressIndicator()
    }
}