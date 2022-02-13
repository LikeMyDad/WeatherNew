package lmd.pet.weathernew.data.entity.response.cities

import com.google.gson.annotations.SerializedName

data class CitiesRecord(
    @SerializedName("fields")
    val cityFields: CitiesFields
)