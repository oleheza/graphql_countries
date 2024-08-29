package ua.oldev.graphqlcountries.countries.data.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Optional
import kotlinx.coroutines.CancellationException
import ua.oldev.graphqlcountries.CountriesListQuery
import ua.oldev.graphqlcountries.CountryDetailsQuery
import ua.oldev.graphqlcountries.countries.domain.repository.CountriesRepository
import ua.oldev.graphqlcountries.type.CountryFilterInput
import ua.oldev.graphqlcountries.type.StringQueryOperatorInput
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : CountriesRepository {
    override suspend fun getAllForContinent(code: String): Result<List<CountriesListQuery.Country>> {
        return try {
            val query = CountriesListQuery(
                filter = Optional.present(
                    value = CountryFilterInput(
                        continent = Optional.present(
                            value = StringQueryOperatorInput(eq = Optional.present(code))
                        )
                    )
                )
            )
            val response = apolloClient.query(query).execute()
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