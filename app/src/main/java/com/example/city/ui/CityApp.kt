package com.example.city.ui

import androidx.navigation.navArgument
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.city.ui.screens.CategoryScreen
import com.example.city.ui.screens.DetailScreen
import com.example.city.ui.screens.PlacesScreen
import com.example.city.data.Category

@Composable
fun CityApp() {
    val navController = rememberNavController()
    val viewModel: CityViewModel = viewModel()

    NavHost(navController, startDestination = "categories") {
        composable(
            route = "categories") {
            CategoryScreen(
                onCategoryClick = { category ->
                    navController.navigate("list/${category.name}")
                }
            )
        }

        composable(
            route = "list/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val category = Category.valueOf(backStackEntry.arguments?.getString("category") ?: "")
            PlacesScreen(
                category = category,
                viewModel = viewModel,
                onItemClick = { recId ->
                    navController.navigate("detail/$recId")
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(
            route = "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetailScreen(id, viewModel = viewModel, onBackClick = { navController.popBackStack() })
        }
    }
}
