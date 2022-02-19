package lmd.pet.weathernew.data.entity.response.cities

import com.google.gson.annotations.SerializedName

data class CityRecord(
    @SerializedName("fields")
    val cityFields: CityFields
)