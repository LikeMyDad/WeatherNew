package lmd.pet.weathernew.data.dataSource

import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.data.entity.response.cities.CityFields

fun CityFields.toModel(): CityModel {
    return CityModel(id, cityName, timeZone, coordCity)
}