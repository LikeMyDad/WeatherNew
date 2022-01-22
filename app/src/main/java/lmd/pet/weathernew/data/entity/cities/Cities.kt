package com.example.weather.data.response.cities

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cities(
    @SerializedName("records")
    val citiesRecords: List<CitiesRecord>? = null
): Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(CitiesRecord))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(citiesRecords)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cities> {
        override fun createFromParcel(parcel: Parcel): Cities {
            return Cities(parcel)
        }

        override fun newArray(size: Int): Array<Cities?> {
            return arrayOfNulls(size)
        }
    }

}