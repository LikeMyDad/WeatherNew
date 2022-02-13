package lmd.pet.weathernew.data.entity.dao.cities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import lmd.pet.weathernew.data.entity.response.cities.Cities

@Dao
interface CitiesDao {
    @Query("SELECT * FROM cityModel")
    suspend fun getCities(): List<CityModel>

    @Query("SELECT * FROM cityModel WHERE id = :id")
    suspend fun getCityById(id: Int): CityModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCities(vararg cities: CityModel)
}