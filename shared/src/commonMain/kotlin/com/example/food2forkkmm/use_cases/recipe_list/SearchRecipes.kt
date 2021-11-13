package com.example.food2forkkmm.use_cases.recipe_list

import com.example.food2forkkmm.datasource.network.RecipeService
import com.example.food2forkkmm.domain.model.Recipe
import com.example.food2forkkmm.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(private val recipeService: RecipeService) {

    fun execute(page: Int, query: String): Flow <DataState<List<Recipe>>> = flow {

        emit(DataState.loading<List<Recipe>>())

        try {
            val recipes = recipeService.search(
                page = page,
                query = query
            )
            emit(DataState.data(message = null, data = recipes))
        }
        catch (e: Exception){
            emit(DataState.error<List<Recipe>>(message = e.message ?: "Unknown error"))
        }
    }
}