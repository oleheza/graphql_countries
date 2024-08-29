package ua.oldev.graphqlcountries.countries.domain.repository

import ua.oldev.graphqlcountries.CountriesListQuery
import ua.oldev.graphqlcountries.CountryDetailsQuery

interface CountriesRepository {
    suspend fun getAllForContinent(code: String): Result<List<CountriesListQuery.Country>>

    suspend fun getByCode(code: String): Result<CountryDetailsQuery.Country?>
}