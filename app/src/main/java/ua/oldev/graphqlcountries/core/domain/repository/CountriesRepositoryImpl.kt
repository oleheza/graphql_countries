package ua.oldev.graphqlcountries.core.domain.repository

import com.apollographql.apollo.ApolloClient
import kotlinx.coroutines.CancellationException
import ua.oldev.graphqlcountries.CountriesListQuery
import ua.oldev.graphqlcountries.CountryDetailsQuery
import ua.oldev.graphqlcountries.core.data.repository.CountriesRepository

class CountriesRepositoryImpl(
    private val apolloClient: ApolloClient
) : CountriesRepository {
    override suspend fun getAll(): Result<List<CountriesListQuery.Country>> {
        return try {
            val response = apolloClient.query(CountriesListQuery()).execute()
            Result.success(response.data?.countries ?: emptyList())
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Result.failure(e)
        }
    }

    override suspend fun getByCode(code: String): Result<CountryDetailsQuery.Country?> {
        return try {
            val response = apolloClient.query(CountryDetailsQuery(code)).execute()
            Result.success(response.data?.country)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Result.failure(e)
        }
    }
}