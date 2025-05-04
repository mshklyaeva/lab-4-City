package com.example.city.ui

import androidx.lifecycle.ViewModel
import com.example.city.R
import com.example.city.data.Category
import com.example.city.data.Place

class CityViewModel : ViewModel() {

    private val places = mapOf(
        Category.CAFES to listOf(
            Place(1, "Lakrica Coffee", R.string.Lakrica, R.drawable.image1),
            Place(2, "Чашка", R.string.Chashka, R.drawable.image2),
            Place(3, "Кофе Семь", R.string.Coffee7, R.drawable.image3),
            Place(4, "Frensis", R.string.Frensis, R.drawable.image4)
        ),
        Category.RESTAURANTS to listOf(
            Place(5, "Нино играет в домино", R.string.Nino, R.drawable.image5),
            Place(6, "Кинза", R.string.Kinza, R.drawable.image6),
            Place(7, "Луна и черепаха", R.string.Luna, R.drawable.image7),
            Place(8, "Утки в городе", R.string.Utki, R.drawable.image8)
        ),
        Category.KIDS to listOf(
            Place(9, "Mango Boom", R.string.MangoBoom, R.drawable.image9),
            Place(10, "Детский парк KÍDO", R.string.KIDO, R.drawable.image10),
            Place(11, "Сигма Парк", R.string.SigmaPark, R.drawable.image11)
        ),
        Category.PARKS to listOf(
            Place(12, "Парк им. Горького", R.string.ParkGorkogo, R.drawable.image12),
            Place(13, "Парк Кирова", R.string.ParkKirova, R.drawable.image13),
            Place(14, "Козий парк", R.string.KoziyPark, R.drawable.image14)
        ),
        Category.MALLS to listOf(
            Place(15, "Талисман", R.string.Talisman, R.drawable.image15),
            Place(16, "Петровский", R.string.Petrovskiy, R.drawable.image16),
            Place(17, "Молл Матрица", R.string.Matrica, R.drawable.image17)
        )
    )

    fun getPlaces(category: Category): List<Place> =
        places[category] ?: emptyList()
}