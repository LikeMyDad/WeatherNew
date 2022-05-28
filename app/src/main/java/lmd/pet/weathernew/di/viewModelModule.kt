package lmd.pet.weathernew.di

import lmd.pet.weathernew.ui.screens.cities.di.citiesModule
import lmd.pet.weathernew.ui.screens.main.di.mainModule
import lmd.pet.weathernew.ui.screens.start.di.startModule
import org.koin.dsl.module

val viewModelModule = module {
    includes(
        startModule,
        mainModule,
        citiesModule
    )
}