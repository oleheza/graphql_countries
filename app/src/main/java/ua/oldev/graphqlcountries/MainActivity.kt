package ua.oldev.graphqlcountries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ua.oldev.graphqlcountries.core.presentation.navigation.AppNavigation
import ua.oldev.graphqlcountries.core.presentation.navigation.destinations.Countries
import ua.oldev.graphqlcountries.core.presentation.theme.GraphQlCountriesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GraphQlCountriesTheme {
                AppNavigation(
                    navHostController = rememberNavController(),
                    startDestination = Countries
                )
            }
        }
    }
}