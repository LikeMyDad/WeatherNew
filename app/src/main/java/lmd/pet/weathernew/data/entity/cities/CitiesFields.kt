package com.example.weather.data.response.cities

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CitiesFields(
    @SerializedName("name")
    val cityName: String? = null,
    @SerializedName("timezone")
    val timeZone: String? = null,
    @SerializedName("coordinates")
    val coordCity: List<Double>? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        (parcel.readDoubleArray(doubleArrayOf()) to listOf<Double>()).second
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cityName)
        parcel.writeString(timeZone)
        parcel.writeDoubleArray(coordCity?.toDoubleArray())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CitiesFields> {
        override fun createFromParcel(parcel: Parcel): CitiesFields {
            return CitiesFields(parcel)
        }

        override fun newArray(size: Int): Array<CitiesFields?> {
            return arrayOfNulls(size)
        }
    }

}
