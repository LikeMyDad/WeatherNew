package lmd.pet.weathernew.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lmd.pet.weathernew.data.repositories.city.CitiesRepository
import lmd.pet.weathernew.data.repositories.city.CitiesRepositoryImpl
import lmd.pet.weathernew.data.repositories.weather.WeatherRepository
import lmd.pet.weathernew.data.repositories.weather.WeatherRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCitiesRepository(citiesRepositoryImpl: CitiesRepositoryImpl): CitiesRepository

    @Binds
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository

}