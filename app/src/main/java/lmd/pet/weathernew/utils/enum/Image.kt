package lmd.pet.weathernew.utils.enum

object Image {
    enum class Size(val type: String) {
        STANDARD(""), NORMAL("@2x"), BIG("@4x")
    }
    enum class Format(val type: String) {
        PNG(".png")
    }
}