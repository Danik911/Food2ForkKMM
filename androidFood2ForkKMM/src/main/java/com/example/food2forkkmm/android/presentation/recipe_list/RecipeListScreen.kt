package com.example.food2forkkmm.android.presentation.recipe_list

import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.food2forkkmm.android.presentation.recipe_list.components.RecipeList
import com.example.food2forkkmm.android.presentation.recipe_list.components.SearchAppBar
import com.example.food2forkkmm.android.presentation.theme.AppTheme
import com.example.food2forkkmm.presentation.recipe_list.RecipeListEvents
import com.example.food2forkkmm.presentation.recipe_list.RecipeListState

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun RecipeListScreen(
    state: RecipeListState,
    onTriggerEvent: (RecipeListEvents) -> Unit,
    onClickRecipeItem: (Int) -> Unit
) {
    AppTheme(displayProgressBar = state.isLoading) {


        Scaffold(
            topBar = {
                SearchAppBar(
                    query = state.query,
                    onQueryChange = {
                                    //TODO
                    },
                    onExecuteSearch = {
                        //TODO
                    }
                )
            }
        ) {
            RecipeList(
                loading = state.isLoading,
                recipes = state.recipes,
                onClickRecipeListItem = onClickRecipeItem,
                onTriggerNextPage = { onTriggerEvent(RecipeListEvents.NextPage) },
                page = state.page
            )
        }
    }

}