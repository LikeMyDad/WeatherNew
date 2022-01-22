package com.example.weather.data.response.cities

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CitiesRecord(
    @SerializedName("fields")
    val cityFields: CitiesFields? = null
): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readParcelable(CitiesFields::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(cityFields, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CitiesRecord> {
        override fun createFromParcel(parcel: Parcel): CitiesRecord {
            return CitiesRecord(parcel)
        }

        override fun newArray(size: Int): Array<CitiesRecord?> {
            return arrayOfNulls(size)
        }
    }

}