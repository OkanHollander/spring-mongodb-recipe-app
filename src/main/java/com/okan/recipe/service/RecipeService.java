package com.okan.recipe.service;

import com.okan.recipe.commands.RecipeCommand;
import com.okan.recipe.domain.Recipe;

import java.util.Set;

/**
 * Author:   Okan Hollander
 * Date:     30/12/2019
 * Time:     19:39
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long id);
}
