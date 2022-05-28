package lmd.pet.weathernew.di

import com.google.gson.GsonBuilder
import lmd.pet.weathernew.BuildConfig
import lmd.pet.weathernew.data.api.CitiesApi
import lmd.pet.weathernew.data.api.WeatherApi
import lmd.pet.weathernew.utils.CitySerialization
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single { HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) } }

    single {
        OkHttpClient.Builder()
            .addInterceptor(interceptor = get())
            .build()
    }

    single { Retrofit.Builder().client(get()) }

    includes(citiesNetworkModule, weatherNetworkModule)
}

val citiesNetworkModule = module {

    fun provideGsonBuilder(serialization: CitySerialization) =
        GsonBuilder().registerTypeAdapter(
            CitySerialization::class.javaObjectType,
            serialization
        )

    fun provideConverterFactory(gson: GsonBuilder) =
        GsonConverterFactory.create(gson.create())

    fun provideCitiesApi(
        retrofit: Retrofit.Builder,
        converterFactory: GsonConverterFactory,
        baseUrl: String
    ): CitiesApi {
        return retrofit.addConverterFactory(converterFactory)
            .baseUrl(baseUrl)
            .build()
            .create(CitiesApi::class.java)
    }

    factory(named("CitiesUrl")) { BuildConfig.citiesUrl }

    factory(named("CitySerialization")) { CitySerialization() }

    factory(named("GsonCity")) { provideGsonBuilder(get(named("CitySerialization"))) }

    factory(named("ConverterCities")) { provideConverterFactory(get(named("GsonCity"))) }

    single(named("CitiesApi")) {
        provideCitiesApi(
            retrofit = get(),
            converterFactory = get(named("ConverterCities")),
            baseUrl = get(named("CitiesUrl"))
        )
    }

}

val weatherNetworkModule = module {

    fun provideConverterFactory() =
        GsonConverterFactory.create()

    fun provideWeatherApi(
        retrofit: Retrofit.Builder,
        converterFactory: GsonConverterFactory,
        baseUrl: String
    ): WeatherApi {
        return retrofit
            .addConverterFactory(converterFactory)
            .baseUrl(baseUrl)
            .build()
            .create(WeatherApi::class.java)
    }

    factory { provideConverterFactory() }

    factory(named("WeatherUrl")) { BuildConfig.weatherUrl }

    single(named("WeatherApi")) {
        provideWeatherApi(
            retrofit = get(),
            converterFactory = get(),
            baseUrl = get(named("WeatherUrl"))
        )
    }
}