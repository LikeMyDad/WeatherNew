package lmd.pet.weathernew.ui.screens.start.di

import lmd.pet.weathernew.ui.screens.start.models.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val startModule = module {
    viewModel { StartViewModel() }
}