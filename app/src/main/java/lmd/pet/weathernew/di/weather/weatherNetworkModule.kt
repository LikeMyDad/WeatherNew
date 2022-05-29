package lmd.pet.weathernew.di.weather

import lmd.pet.weathernew.BuildConfig
import lmd.pet.weathernew.data.api.WeatherApi
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

    single { provideConverterFactory() }

    single(named("WeatherUrl")) { BuildConfig.weatherUrl }

    single(named("WeatherApi")) {
        provideWeatherApi(
            retrofit = get(named("RetrofitBuilder")),
            converterFactory = get(),
            baseUrl = get(named("WeatherUrl"))
        )
    }
}