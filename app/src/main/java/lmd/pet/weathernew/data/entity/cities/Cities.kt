package lmd.pet.weathernew.data.entity.cities

import com.example.weather.data.response.cities.CitiesRecord
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cities(
    @SerializedName("records")
    val citiesRecords: List<CitiesRecord>? = null
): Serializable