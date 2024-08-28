package ua.oldev.graphqlcountries.continents.domain.mappers

import ua.oldev.graphqlcountries.ContinentsListQuery
import ua.oldev.graphqlcountries.continents.domain.model.ContinentListModel

fun ContinentsListQuery.Continent.toListModel(): ContinentListModel {
    return ContinentListModel(
        code = this.code,
        name = this.name
    )
}