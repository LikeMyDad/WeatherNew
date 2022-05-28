package lmd.pet.weathernew.di

import lmd.pet.weathernew.di.cities.citiesDataModule
import lmd.pet.weathernew.di.weather.weatherDataModule
import org.koin.dsl.module

val dataModule = module {
    includes(citiesDataModule, weatherDataModule)
}