package com.example.food2forkkmm.use_cases.recipe_list

import com.example.food2forkkmm.datasource.cache.RecipeCache
import com.example.food2forkkmm.datasource.network.RecipeService
import com.example.food2forkkmm.domain.model.GenericMessageInfo
import com.example.food2forkkmm.domain.model.Recipe
import com.example.food2forkkmm.domain.model.UIComponentType
import com.example.food2forkkmm.domain.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService,
    private val recipeCache: RecipeCache
) {

    fun execute(page: Int, query: String): Flow<DataState<List<Recipe>>> = flow {

        emit(DataState.loading<List<Recipe>>())

        try {
            val recipes = recipeService.search(
                page = page,
                query = query
            )

            delay(500)

            if (query == "error") {
                throw Exception("Forcing an error... Search FAILED")
            }

            //insert into cache
            recipeCache.insert(recipes = recipes)

            val cacheResult = if (query.isBlank()) {
                recipeCache.getAll(page = page)
            } else {
                recipeCache.search(
                    query = query,
                    page = page
                )
            }

            emit(DataState.data(message = null, data = cacheResult))
        } catch (e: Exception) {
            emit(
                DataState.error<List<Recipe>>(
                    message = GenericMessageInfo.Builder()
                        .id("SearchRecipes.Error")
                        .title("Error")
                        .uiComponentType(UIComponentType.Dialog)
                        .description(e.message ?: "Unknown Error")
                ))
        }
    }
}