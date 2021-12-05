package com.example.food2forkkmm.di

import com.example.food2forkkmm.use_cases.recipe_detail.GetRecipe

class GetRecipeModule(
    private val cacheModule: CacheModule,
) {
    val getRecipe: GetRecipe by lazy {
        GetRecipe(
            recipeCache = cacheModule.recipeCache
        )
    }
}