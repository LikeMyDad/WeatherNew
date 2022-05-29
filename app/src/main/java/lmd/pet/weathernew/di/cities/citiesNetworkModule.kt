package lmd.pet.weathernew.di.cities

import com.google.gson.GsonBuilder
import lmd.pet.weathernew.BuildConfig
import lmd.pet.weathernew.data.api.CitiesApi
import lmd.pet.weathernew.utils.CitySerialization
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val citiesNetworkModule = module {

    single(named("CitiesUrl")) { BuildConfig.citiesUrl }

    single(named("CitySerialization")) { CitySerialization() }

    single(named("GsonCity")) { provideGsonBuilder(get(named("CitySerialization"))) }

    single(named("ConverterCities")) { provideConverterFactory(get(named("GsonCity"))) }

    single(named("CitiesApi")) {
        provideCitiesApi(
            retrofit = get(named("RetrofitBuilder")),
            converterFactory = get(named("ConverterCities")),
            baseUrl = get(named("CitiesUrl"))
        )
    }

}

private fun provideGsonBuilder(serialization: CitySerialization) =
    GsonBuilder().registerTypeAdapter(
        CitySerialization::class.javaObjectType,
        serialization
    )

private fun provideConverterFactory(gson: GsonBuilder) =
    GsonConverterFactory.create(gson.create())

private fun provideCitiesApi(
    retrofit: Retrofit.Builder,
    converterFactory: GsonConverterFactory,
    baseUrl: String
): CitiesApi {
    return retrofit.addConverterFactory(converterFactory)
        .baseUrl(baseUrl)
        .build()
        .create(CitiesApi::class.java)
}