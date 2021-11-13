package com.example.food2forkkmm.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.food2forkkmm.android.presentation.recipe_detail.RecipeDetailScreen
import com.example.food2forkkmm.android.presentation.recipe_detail.RecipeDetailViewModel
import com.example.food2forkkmm.android.presentation.recipe_list.RecipeListScreen
import com.example.food2forkkmm.android.presentation.recipe_list.RecipeListViewModel




@ExperimentalStdlibApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(route = Screen.RecipeList.route) {
            val viewModel: RecipeListViewModel = hiltViewModel()
            RecipeListScreen(onSelectedRecipe = { recipeId ->
                navController.navigate(Screen.RecipeDetail.route + "/$recipeId")

            })
        }
        composable(
            route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId"){
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val viewModel: RecipeDetailViewModel = hiltViewModel()
            RecipeDetailScreen(
                recipe = viewModel.recipe.value
                //navBackStackEntry.arguments?.getInt("recipeId") Don't need to extract this from arguments
                // because we use SavedStateHandle
            )
        }
    }
}