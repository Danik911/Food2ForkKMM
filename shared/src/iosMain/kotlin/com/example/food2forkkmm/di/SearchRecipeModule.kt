package com.example.food2forkkmm.di

import com.example.food2forkkmm.use_cases.recipe_list.SearchRecipes

class SearchRecipeModule(
    private val networkModule: NetworkModule,
    private val cacheModule: CacheModule,
) {
    val searchRecipes: SearchRecipes by lazy {
        SearchRecipes(
            recipeService = networkModule.recipeService,
            recipeCache = cacheModule.recipeCache,
        )
    }

}