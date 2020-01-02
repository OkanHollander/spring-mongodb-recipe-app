package com.okan.recipe.converters;

import com.okan.recipe.commands.RecipeCommand;
import com.okan.recipe.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Author:   Okan Hollander
 * Date:     02/01/2020
 * Time:     15:33
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryCommand,
                                 IngredientCommandToIngredient ingredientCommand,
                                 NotesCommandToNotes notesCommand) {
        this.categoryConverter = categoryCommand;
        this.ingredientConverter = ingredientCommand;
        this.notesConverter = notesCommand;
    }


    @Override
    public Recipe convert(RecipeCommand recipeCommand) {
        if (recipeCommand != null) {
            final Recipe recipe = new Recipe();
            recipe.setId(recipeCommand.getId());
            recipe.setDescription(recipeCommand.getDescription());
            recipe.setCookTime(recipeCommand.getCookTime());
            recipe.setPrepTime(recipeCommand.getPrepTime());
            recipe.setServings(recipeCommand.getServings());
            recipe.setSource(recipeCommand.getSource());
            recipe.setUrl(recipeCommand.getUrl());
            recipe.setDifficulty(recipeCommand.getDifficulty());
            recipe.setDirections(recipeCommand.getDirections());
            recipe.setNotes(notesConverter.convert(recipeCommand.getNotes()));

            if (recipeCommand != null && recipeCommand.getCategories().size() > 0) {
                recipeCommand.getCategories()
                        .forEach(category -> recipe.getCategories().add(categoryConverter.convert(category)));
            }

            if (recipeCommand != null && recipeCommand.getIngredients().size() > 0) {
                recipeCommand.getIngredients()
                        .forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
            }

            return recipe;
        }

        return null;
    }
}
