package com.example.food2forkkmm.use_cases.recipe_detail

import com.example.food2forkkmm.datasource.cache.RecipeCache
import com.example.food2forkkmm.domain.model.Recipe
import com.example.food2forkkmm.domain.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipe(private val recipeCache: RecipeCache) {

    fun execute(recipeId: Int): Flow<DataState<Recipe>> = flow {


        try {
            emit(DataState.loading<Recipe>())

           delay(2000)
            val recipe = recipeCache.get(recipeId)
            emit(DataState.data(message = null, data = recipe))
        } catch (e: Exception) {
            emit(DataState.error<Recipe>(message = e.message ?: "Unknown error"))
        }

    }

}