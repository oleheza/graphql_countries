package ua.oldev.graphqlcountries.core.presentation.navigation.destinations

data object Continents : Destination.NoArgumentDestination("continents")

data object Countries : Destination("countries", "continent_code") {
    const val CONTINENT_CODE_KEY = "continent_code"

    operator fun invoke(continentCode: String) =
        route.appendParams(CONTINENT_CODE_KEY to continentCode)
}

data object CountryDetails : Destination("country_details", "country_code") {
    const val COUNTRY_CODE_KEY = "country_code"

    operator fun invoke(countryCode: String) = route.appendParams(COUNTRY_CODE_KEY to countryCode)

}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)
    params.forEach { param ->
        param.second?.toString()?.let { argument ->
            builder.append("/${argument}")
        }
    }
    return builder.toString()
}