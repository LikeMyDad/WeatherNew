package lmd.pet.weathernew.utils.serialization

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

class CitySerialization: JsonSerializer<String> {

    override fun serialize(
        src: String?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonObject().apply {
            addProperty("id", src?.toInt() ?: 0)
        }
    }

}