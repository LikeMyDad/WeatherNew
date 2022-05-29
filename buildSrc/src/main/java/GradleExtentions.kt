import org.gradle.api.Project

fun Project.getWeatherKey(): String {
    return findProperty("weatherKey") as? String ?: ""
}

fun Project.getWeatherUrl(): String {
    return findProperty("weatherUrl") as? String ?: ""
}

fun Project.getCitiesUrl(): String {
    return findProperty("citiesUrl") as? String ?: ""
}

fun Project.getWeatherIconUrl(): String {
    return findProperty("weatherIconUrl") as? String ?: ""
}