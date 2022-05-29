package lmd.pet.weathernew.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatUnixTime(unix: Long, pattern: String): String {
    return SimpleDateFormat(pattern, Locale.ENGLISH).format(Date(unix * 1000))
}