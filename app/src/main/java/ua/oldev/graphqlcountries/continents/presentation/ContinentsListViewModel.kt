package ua.oldev.graphqlcountries.continents.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ua.oldev.graphqlcountries.continents.domain.repository.ContinentsRepository
import javax.inject.Inject

@HiltViewModel
class ContinentsListViewModel @Inject constructor(
    private val continentsRepository: ContinentsRepository
) : ViewModel() {

    val state: StateFlow<ContinentsListScreenState>
        get() = internalState.asStateFlow()

    private val internalState = MutableStateFlow(ContinentsListScreenState())

    private fun loadContinents(){

    }
}