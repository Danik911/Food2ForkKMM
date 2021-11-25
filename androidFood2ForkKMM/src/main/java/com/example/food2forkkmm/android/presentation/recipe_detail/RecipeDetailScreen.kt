package com.example.food2forkkmm.android.presentation.recipe_detail

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.food2forkkmm.android.presentation.components.RecipeImage
import com.example.food2forkkmm.android.presentation.recipe_detail.components.RecipeView
import com.example.food2forkkmm.android.presentation.recipe_list.components.RecipeCard
import com.example.food2forkkmm.android.presentation.theme.AppTheme
import com.example.food2forkkmm.domain.model.Recipe


@ExperimentalStdlibApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun RecipeDetailScreen(
    recipe: Recipe?
) {
    AppTheme(displayProgressBar = false) {
        if (recipe == null) {
            Text("Loading")
        } else {
            RecipeView(recipe = recipe)
        }
    }

}
