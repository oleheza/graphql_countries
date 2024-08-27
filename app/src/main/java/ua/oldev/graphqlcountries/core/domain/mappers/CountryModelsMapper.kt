package ua.oldev.graphqlcountries.core.domain.mappers

import ua.oldev.graphqlcountries.CountriesListQuery
import ua.oldev.graphqlcountries.CountryDetailsQuery
import ua.oldev.graphqlcountries.core.domain.model.CountryDetailsModel
import ua.oldev.graphqlcountries.core.domain.model.CountryListModel

fun CountriesListQuery.Country.mapToListModel(): CountryListModel {
    return CountryListModel(
        code = this.code,
        name = this.name,
        emoji = this.emoji
    )
}

fun CountryDetailsQuery.Country.mapToModel(): CountryDetailsModel {
    return CountryDetailsModel(
        name = this.name,
        capital = this.capital,
        emoji = this.emoji
    )
}