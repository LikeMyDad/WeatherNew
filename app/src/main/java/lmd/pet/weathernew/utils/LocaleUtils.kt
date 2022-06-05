package lmd.pet.weathernew.utils

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import java.util.*

class LocaleUtils(context: Context) : ContextWrapper(context) {
    fun setLocale(pref: String?) = updateResources(pref ?: "en") //use locale codes

    fun updateResources(language: String): Configuration {
        return resources.run {
            val locale = Locale(language)
            val config = configuration

            Locale.setDefault(locale)
            config.setLocale(locale)
            config.setLayoutDirection(locale)

            config
        }
    }

}