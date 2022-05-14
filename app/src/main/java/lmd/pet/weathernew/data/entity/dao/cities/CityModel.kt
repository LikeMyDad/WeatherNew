package lmd.pet.weathernew.data.entity.dao.cities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CityModel(
    @PrimaryKey val id: Int,
    val cityName: String,
    val timeZone: String,
    val coordCity: List<Double>,
    val isShowCityWeather: Boolean = false
)