package lmd.pet.weathernew.di

import lmd.pet.weathernew.data.repositories.city.CitiesRepository
import lmd.pet.weathernew.data.repositories.city.CitiesRepositoryImpl
import lmd.pet.weathernew.data.repositories.weather.WeatherRepository
import lmd.pet.weathernew.data.repositories.weather.WeatherRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::CitiesRepositoryImpl) bind CitiesRepository::class
    singleOf(::WeatherRepositoryImpl) bind WeatherRepository::class
}