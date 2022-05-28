package lmd.pet.weathernew.di.weather

import lmd.pet.weathernew.core.network.WeatherNetwork
import lmd.pet.weathernew.data.dataSource.weather.WeatherDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val weatherDataModule = module {
    singleOf(::WeatherNetwork)
    singleOf(::WeatherDataSource)
}