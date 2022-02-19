package lmd.pet.weathernew.data.entity.response.cities

import com.google.gson.annotations.SerializedName

data class Cities(
    @SerializedName("records")
    val citiesRecords: List<CityRecord>
)