package lmd.pet.weathernew.utils

import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.os.LocaleList
import java.util.*

class LocaleUtils {

    companion object {
        fun wrap(context: Context, lang: String): ContextWrapper {
            val resources = context.resources
            val configuration = resources.configuration
            val newLocale = Locale(lang)

            val newContext = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                configuration.setLocale(newLocale)
                val localeList = LocaleList(newLocale)
                LocaleList.setDefault(localeList)
                configuration.setLocales(localeList)
                context.createConfigurationContext(configuration)
            } else {
                configuration.setLocale(newLocale)
                context.createConfigurationContext(configuration)
            }

            return ContextWrapper(newContext)
        }
    }

}