package lmd.pet.weathernew

import android.app.Application
import lmd.pet.weathernew.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                appModule,
                domainModule,
                roomModule,
                repositoryModule,
                viewModelModule,
                dataModule,
                networkModule
            )
        }
    }
}