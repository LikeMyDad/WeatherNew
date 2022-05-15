package lmd.pet.weathernew.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CitiesUrl