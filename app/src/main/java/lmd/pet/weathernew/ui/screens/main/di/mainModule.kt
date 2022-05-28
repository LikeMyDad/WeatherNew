package lmd.pet.weathernew.ui.screens.main.di

import lmd.pet.weathernew.ui.screens.main.models.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel {
        MainViewModel(
            citiesWeatherUseCase = get(),
            cityWeatherUseCase = get()
        )
    }
}