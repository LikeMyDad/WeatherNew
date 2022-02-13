package lmd.pet.weathernew.data.entity.response.cities

import com.google.gson.annotations.SerializedName

data class CitiesFields(
    @SerializedName("name")
    val cityName: String,
    @SerializedName("timezone")
    val timeZone: String,
    @SerializedName("coordinates")
    val coordCity: List<Double>,
    @SerializedName("geoname_id")
    val id: Int
)