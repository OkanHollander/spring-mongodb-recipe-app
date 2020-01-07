package com.okan.recipe.service;

import com.okan.recipe.commands.IngredientCommand;

/**
 * Author:   Okan Hollander
 * Date:     03/01/2020
 * Time:     08:43
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(String recipeId, String idToDelete);
}
