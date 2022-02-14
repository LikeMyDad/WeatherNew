package lmd.pet.weathernew.utils

import lmd.pet.weathernew.utils.network.NetworkResponse
import lmd.pet.weathernew.data.entity.response.cities.Cities
import lmd.pet.weathernew.data.entity.response.weather.DailyWeather

typealias WeatherResponse = NetworkResponse<DailyWeather>
typealias CitiesResponse = NetworkResponse<Cities>