package com.example.city.ui

import androidx.lifecycle.ViewModel
import com.example.city.data.Category
import com.example.city.data.CityRepository
import com.example.city.data.Place

class CityViewModel(private val places: CityRepository = CityRepository()) : ViewModel() {

    fun getPlaces(category: Category): List<Place> =
        places.getPlaces(category)
}