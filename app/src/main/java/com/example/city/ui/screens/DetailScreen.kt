package com.example.city.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.city.ui.CityViewModel
import com.example.city.data.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(placeId: Int, viewModel: CityViewModel, onBackClick: () -> Unit) {
    val allPlaces = Category.values().flatMap { viewModel.getPlaces(it) }
    val place = allPlaces.find { it.id == placeId } ?: return
    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
    ) {
        TopAppBar(
            title = { Text(place.title) },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Назад"
                    )
                }
            }
        )
        Image(painter = painterResource(id = place.image), contentDescription = null, modifier = Modifier.padding(5.dp))
        Spacer(modifier = Modifier.padding(5.dp).height(8.dp))
        Text(text = stringResource(id = place.description), modifier = Modifier.padding(5.dp))
    }
}
