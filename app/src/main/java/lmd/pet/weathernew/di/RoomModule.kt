package lmd.pet.weathernew.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import lmd.pet.weathernew.data.dataBase.CitiesDataBase
import lmd.pet.weathernew.data.entity.dao.cities.CitiesDao

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideCitiesDataBase(@ApplicationContext context: Context): CitiesDataBase =
        Room.databaseBuilder(
            context.applicationContext,
            CitiesDataBase::class.java,
            "CitiesDataBase"
        ).build()

    @Provides
    fun provideCitiesDao(db: CitiesDataBase): CitiesDao = db.getCitiesDao()

}