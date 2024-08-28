package ua.oldev.graphqlcountries.continents.data.repository

import com.apollographql.apollo.ApolloClient
import kotlinx.coroutines.CancellationException
import ua.oldev.graphqlcountries.ContinentsListQuery
import ua.oldev.graphqlcountries.continents.domain.repository.ContinentsRepository
import javax.inject.Inject

class ContinentsRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : ContinentsRepository {
    override suspend fun getAll(): Result<List<ContinentsListQuery.Continent>> {
        return try {
            val response = apolloClient.query(ContinentsListQuery()).execute()
            Result.success(response.data?.continents ?: emptyList())
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Result.failure(e)
        }
    }
}