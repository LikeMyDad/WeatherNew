package lmd.pet.weathernew.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import lmd.pet.weathernew.data.entity.dao.cities.CitiesDao

@Database(
    entities = [CitiesDao::class],
    version = 1
)
abstract class CitiesDataBase: RoomDatabase() {

    abstract fun getCitiesDao(): CitiesDao

}