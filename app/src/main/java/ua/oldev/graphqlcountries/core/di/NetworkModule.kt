package ua.oldev.graphqlcountries.core.di

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ua.oldev.graphqlcountries.BuildConfig

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(BuildConfig.GRAPHQL_BASE_URL)
            .build()
    }

}