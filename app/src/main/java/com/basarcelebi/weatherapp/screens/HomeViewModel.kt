package com.basarcelebi.weatherapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basarcelebi.weatherapp.models.BaseModel
import com.basarcelebi.weatherapp.models.Location
import com.basarcelebi.weatherapp.repositories.WeatherRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.http.Query

class HomeViewModel:ViewModel(),KoinComponent {
    val repo:WeatherRepo by inject()

    private val _locations:MutableStateFlow<BaseModel<List<Location>>?> = MutableStateFlow(null)
    val locations = _locations.asStateFlow()

    fun searchLocation(query: String){
        viewModelScope.launch {
            _locations.update { BaseModel.Loading }
            repo.searchLocation(query).also {data ->_locations.update { data }
            }
        }
    }

}