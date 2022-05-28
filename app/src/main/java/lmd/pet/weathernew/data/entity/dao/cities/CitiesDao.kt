package lmd.pet.weathernew.data.entity.dao.cities

import androidx.room.*

@Dao
interface CitiesDao {
    @Query("SELECT * FROM cityModel")
    suspend fun getCities(): List<CityModel>

    @Query("SELECT * FROM cityModel WHERE cityName LIKE :searchQuery")
    suspend fun getCitiesBySearchQuery(searchQuery: String): List<CityModel>

    @Query("SELECT * FROM cityModel WHERE id = :id")
    suspend fun getCityById(id: Int): CityModel

    @Query("SELECT * FROM cityModel WHERE isShowCityWeather = 1")
    suspend fun getCitiesWeather(): List<CityModel>

    @Query("UPDATE cityModel SET isShowCityWeather = :isShowCityWeather WHERE id = :id")
    suspend fun setStateShowCityWeatherById(id: Int, isShowCityWeather: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCities(vararg cities: CityModel)
}