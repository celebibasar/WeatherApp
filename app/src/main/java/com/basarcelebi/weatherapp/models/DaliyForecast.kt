package com.basarcelebi.weatherapp.models

import com.google.gson.annotations.SerializedName

data class DaliyForecast(
    @SerializedName("Date")
    val date:String,
    @SerializedName("EpochDate")
    val epochDate:Long,
    @SerializedName("Temperature")
    val temperature:Temperature,
    @SerializedName("Day")
    val day:WeatherStat,
    @SerializedName("Night")
    val night:WeatherStat

)
data class Temperature(
    @SerializedName("Minimum")
    val min:Value,
    @SerializedName("Maximum")
    val maximum:Value
)
data class WeatherStat(
    @SerializedName("Icon")
    val icon:Int,
    @SerializedName("IconPhrase")
    val iconPhrase:String,
    @SerializedName("HasPrecipitation")
    val hasPrecipitation:Boolean
)