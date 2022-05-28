package lmd.pet.weathernew.di

import lmd.pet.weathernew.di.cities.citiesNetworkModule
import lmd.pet.weathernew.di.weather.weatherNetworkModule
import org.koin.dsl.module

val networkModule = module {
    includes(
        citiesNetworkModule,
        weatherNetworkModule
    )
}