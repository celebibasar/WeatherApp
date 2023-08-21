package com.basarcelebi.weatherapp.repositories

import com.basarcelebi.weatherapp.models.BaseModel
import com.basarcelebi.weatherapp.models.DailyForecasts
import com.basarcelebi.weatherapp.models.HourlyForecast
import com.basarcelebi.weatherapp.models.Location


interface WeatherRepo {
    suspend fun searchLocation(query: String):BaseModel<List<Location>>
    suspend fun getDailyForecast(locationKey: String): BaseModel<DailyForecasts>
    suspend fun getHourlyForecast(locationKey: String):BaseModel<List<HourlyForecast>>
}