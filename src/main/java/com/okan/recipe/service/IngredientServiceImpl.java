package com.okan.recipe.service;

import com.okan.recipe.commands.IngredientCommand;
import com.okan.recipe.converters.IngredientToIngredientCommand;
import com.okan.recipe.domain.Recipe;
import com.okan.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author:   Okan Hollander
 * Date:     03/01/2020
 * Time:     08:43
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    @Autowired
    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }


    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isEmpty()) {
            log.error("Recipe with id:" + recipeId + " not Found!");
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientOptional =
                recipe.getIngredients().stream()
                        .filter(ingredient -> ingredient.getId().equals(ingredientId))
                        .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if (ingredientOptional.isEmpty()) {
            log.error("Ingredient with id: " + ingredientId + " not found!");
        }

        return ingredientOptional.get();
    }
}
