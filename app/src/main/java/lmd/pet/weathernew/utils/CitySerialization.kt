package lmd.pet.weathernew.utils

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import lmd.pet.weathernew.data.entity.response.cities.CityFields
import java.lang.reflect.Type

class CitySerialization: JsonSerializer<CityFields> {

    override fun serialize(
        src: CityFields?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonObject().apply {
            addProperty("id", src?.id?.toInt() ?: 0)
        }
    }

}