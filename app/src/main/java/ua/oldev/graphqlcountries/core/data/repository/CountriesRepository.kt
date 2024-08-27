package ua.oldev.graphqlcountries.core.data.repository

import ua.oldev.graphqlcountries.CountriesListQuery
import ua.oldev.graphqlcountries.CountryDetailsQuery

interface CountriesRepository {
    suspend fun getAll(): Result<List<CountriesListQuery.Country>>

    suspend fun getByCode(code: String): Result<CountryDetailsQuery.Country?>
}