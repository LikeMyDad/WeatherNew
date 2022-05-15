package lmd.pet.weathernew.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromDoubleList(value: List<Double>): String {
        return gson.toJson(value, typeListDouble)
    }

    @TypeConverter
    fun toDoubleList(value: String): List<Double> {
        return gson.fromJson(value, typeListDouble)
    }

    companion object {
        private val gson = Gson()
        private val typeListDouble = object : TypeToken<List<Double>>(){}.type
    }
}