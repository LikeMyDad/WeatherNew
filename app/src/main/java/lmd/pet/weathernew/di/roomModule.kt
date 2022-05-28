package lmd.pet.weathernew.di

import android.content.Context
import androidx.room.Room
import lmd.pet.weathernew.data.dataBase.CitiesDataBase
import org.koin.dsl.module

val roomModule = module {

    fun provideCitiesDataBase(context: Context) =
        Room.databaseBuilder(
            context,
            CitiesDataBase::class.java,
            "CitiesDataBase"
        ).build()

    fun provideCitiesDao(db: CitiesDataBase) = db.getCitiesDao()

    single { provideCitiesDataBase(get()) }
    single { provideCitiesDao(get()) }

}