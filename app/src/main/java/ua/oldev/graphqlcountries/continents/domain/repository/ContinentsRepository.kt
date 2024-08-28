package ua.oldev.graphqlcountries.continents.domain.repository

import ua.oldev.graphqlcountries.ContinentsListQuery

interface ContinentsRepository {
    suspend fun getAll(): Result<List<ContinentsListQuery.Continent>>
}