package ua.oldev.graphqlcountries.countries.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.graphqlcountries.core.presentation.theme.GraphQlCountriesTheme

@Composable
fun EmojiCircle(
    modifier: Modifier = Modifier,
    emoji: String,
    backgroundColor: Color = Color.Transparent
) {
    Box(
        modifier = modifier.background(
            shape = CircleShape,
            color = backgroundColor
        ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = emoji)
    }
}

@Preview
@Composable
private fun EmojiCirclePreview() {
    GraphQlCountriesTheme {
        EmojiCircle(emoji = "\uD83C\uDDFA\uD83C\uDDE6")
    }
}