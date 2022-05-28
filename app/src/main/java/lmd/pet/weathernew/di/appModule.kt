package lmd.pet.weathernew.di

import org.koin.dsl.module

val appModule = module {
    includes(
        networkModule,
        roomModule
    )
}

