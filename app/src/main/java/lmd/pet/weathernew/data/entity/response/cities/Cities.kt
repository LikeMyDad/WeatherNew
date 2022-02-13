package lmd.pet.weathernew.data.entity.response.cities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cities(
    @SerializedName("records")
    val citiesRecords: List<CitiesRecord>
)