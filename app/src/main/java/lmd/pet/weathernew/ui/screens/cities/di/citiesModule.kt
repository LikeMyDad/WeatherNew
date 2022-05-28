package lmd.pet.weathernew.ui.screens.cities.di

import lmd.pet.weathernew.ui.screens.cities.models.CitiesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val citiesModule = module {
    viewModel {
        CitiesViewModel(
            citiesUseCase = get(),
            setStateToShowCityWeatherUseCase = get()
        )
    }
}