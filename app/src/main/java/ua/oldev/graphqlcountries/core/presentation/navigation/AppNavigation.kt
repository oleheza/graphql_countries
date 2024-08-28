package ua.oldev.graphqlcountries.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ua.oldev.graphqlcountries.continents.presentation.ContinentsListScreen
import ua.oldev.graphqlcountries.continents.presentation.ContinentsListViewModel
import ua.oldev.graphqlcountries.core.presentation.navigation.destinations.Continents
import ua.oldev.graphqlcountries.core.presentation.navigation.destinations.Countries
import ua.oldev.graphqlcountries.core.presentation.navigation.destinations.CountryDetails
import ua.oldev.graphqlcountries.core.presentation.navigation.destinations.Destination
import ua.oldev.graphqlcountries.countries.presentation.details.CountryDetailsScreen
import ua.oldev.graphqlcountries.countries.presentation.details.CountryDetailsViewModel
import ua.oldev.graphqlcountries.countries.presentation.list.CountriesListScreen
import ua.oldev.graphqlcountries.countries.presentation.list.CountriesListViewModel

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

        composable(Continents.fullRoute) {
            val viewModel = hiltViewModel<ContinentsListViewModel>()
            val state = viewModel.state.collectAsStateWithLifecycle().value
            ContinentsListScreen(
                state = state,
                onContinentSelected = remember {
                    { code ->
                        navHostController.navigate(Countries(code))
                    }
                }
            )
        }

        composable(Countries.fullRoute) {
            val viewModel = hiltViewModel<CountriesListViewModel>()
            val state = viewModel.state.collectAsStateWithLifecycle().value
            CountriesListScreen(
                state = state,
                onCountrySelected = remember {
                    { code ->
                        navHostController.navigate(CountryDetails(code))
                    }
                },
                onBackClick = remember {
                    {
                        navHostController.navigateUp()
                    }
                }
            )
        }

        composable(CountryDetails.fullRoute) {
            val viewModel = hiltViewModel<CountryDetailsViewModel>()
            val state = viewModel.state.collectAsStateWithLifecycle().value
            CountryDetailsScreen(
                state = state,
                onBackClick = remember {
                    {
                        navHostController.navigateUp()
                    }
                }
            )
        }
    }
}