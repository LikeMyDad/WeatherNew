package lmd.pet.weathernew.di

import lmd.pet.weathernew.domain.useCases.cities.GetCitiesInteractor
import lmd.pet.weathernew.domain.useCases.cities.GetCitiesWeatherInteractor
import lmd.pet.weathernew.domain.useCases.cities.SetStateToShowCityWeatherInteractor
import lmd.pet.weathernew.domain.useCases.weather.GetCityWeatherInteractor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::GetCitiesInteractor)
    singleOf(::GetCitiesWeatherInteractor)
    singleOf(::SetStateToShowCityWeatherInteractor)
    singleOf(::GetCityWeatherInteractor)
}