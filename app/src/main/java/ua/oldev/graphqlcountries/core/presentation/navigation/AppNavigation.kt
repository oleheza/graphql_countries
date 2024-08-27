package ua.oldev.graphqlcountries.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ua.oldev.graphqlcountries.core.presentation.navigation.destinations.Countries
import ua.oldev.graphqlcountries.core.presentation.navigation.destinations.Destination
import ua.oldev.graphqlcountries.countries.list.CountriesListScreen
import ua.oldev.graphqlcountries.countries.list.CountriesListViewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: Destination
) {

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination.fullRoute
    ) {
        composable(Countries.fullRoute) {
            val viewModel = hiltViewModel<CountriesListViewModel>()
            val state = viewModel.state.collectAsStateWithLifecycle().value
            CountriesListScreen(
                state = state,
                onCountrySelected = remember {
                    { code ->

                    }
                }
            )
        }
    }
}