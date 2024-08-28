package ua.oldev.graphqlcountries.core.presentation

import ua.oldev.graphqlcountries.countries.domain.model.CountryListModel

val ukraine = CountryListModel(
    code = "UA",
    emoji = "\uD83C\uDDFA\uD83C\uDDE6",
    name = "Ukraine"
)

val netherlands = CountryListModel(
    code = "NL",
    emoji = "\uD83C\uDDF3\uD83C\uDDF1",
    name = "Netherlands"
)

val newZealand = CountryListModel(
    code = "NZ",
    emoji = "\uD83C\uDDF3\uD83C\uDDFF",
    name = "New Zealand"
)

val allCountries = listOf(netherlands, newZealand, ukraine)