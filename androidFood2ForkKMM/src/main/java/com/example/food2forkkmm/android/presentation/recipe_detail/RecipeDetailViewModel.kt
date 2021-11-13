package com.example.food2forkkmm.android.presentation.recipe_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.food2forkkmm.datasource.network.RecipeService
import com.example.food2forkkmm.domain.model.Recipe
import com.example.food2forkkmm.domain.util.DatetimeUtil
import com.example.food2forkkmm.use_cases.recipe_detail.GetRecipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalStdlibApi
@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getRecipe: GetRecipe

) : ViewModel() {

    val recipe: MutableState<Recipe?> = mutableStateOf(null)

    init {
        savedStateHandle.get<Int>("recipeId")?.let { recipeId ->
            viewModelScope.launch {
                getRecipe(recipeId = recipeId)
            }
        }

    }

    private fun getRecipe(recipeId: Int){
        getRecipe.execute(recipeId = recipeId).onEach { dataState->

            println("RecipeDetailVM: ${dataState.isLoading}")

            dataState.data?.let { recipe ->
                println("RecipeDetailVM: ${recipe}")
                this.recipe.value = recipe
            }

            dataState.message?.let { message ->
                println("RecipeDetailVM: ${message}")
            }            
        }.launchIn(viewModelScope)
    }
}