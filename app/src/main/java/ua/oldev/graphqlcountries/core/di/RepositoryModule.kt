package ua.oldev.graphqlcountries.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ua.oldev.graphqlcountries.continents.data.repository.ContinentsRepositoryImpl
import ua.oldev.graphqlcountries.continents.domain.repository.ContinentsRepository
import ua.oldev.graphqlcountries.countries.data.repository.CountriesRepositoryImpl
import ua.oldev.graphqlcountries.countries.domain.repository.CountriesRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCountriesRepository(repository: CountriesRepositoryImpl): CountriesRepository

    @Binds
    abstract fun bindContinentsRepository(repository: ContinentsRepositoryImpl): ContinentsRepository
}