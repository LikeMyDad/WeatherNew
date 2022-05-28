package lmd.pet.weathernew.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import lmd.pet.weathernew.data.entity.dao.cities.CitiesDao
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.utils.Converters

@Database(
    entities = [CityModel::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class CitiesDataBase : RoomDatabase() {

    abstract fun getCitiesDao(): CitiesDao

}