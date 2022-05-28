package lmd.pet.weathernew.di.weather

import lmd.pet.weathernew.core.network.WeatherNetwork
import lmd.pet.weathernew.data.dataSource.weather.WeatherDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val weatherDataModule = module {
    single {
        WeatherNetwork(get(named("WeatherApi")))
    }
    singleOf(::WeatherDataSource)
}