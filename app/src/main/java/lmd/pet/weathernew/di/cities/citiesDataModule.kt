package lmd.pet.weathernew.di.cities

import lmd.pet.weathernew.core.network.CitiesNetwork
import lmd.pet.weathernew.data.dataSource.cities.CitiesDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val citiesDataModule = module {
    singleOf(::CitiesNetwork)
    singleOf(::CitiesDataSource)
}