package com.okan.recipe.converters;

import com.okan.recipe.commands.RecipeCommand;
import com.okan.recipe.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Author:   Okan Hollander
 * Date:     02/01/2020
 * Time:     15:05
 */
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryConveter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConveter, IngredientToIngredientCommand ingredientConverter, NotesToNotesCommand notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {
        if (recipe != null) {
            final RecipeCommand command = new RecipeCommand();
            command.setId(recipe.getId());
            command.setDescription(recipe.getDescription());
            command.setCookTime(recipe.getCookTime());
            command.setPrepTime(recipe.getPrepTime());
            command.setServings(recipe.getServings());
            command.setSource(recipe.getSource());
            command.setUrl(recipe.getUrl());
            command.setDifficulty(recipe.getDifficulty());
            command.setDirections(recipe.getDirections());
            command.setNotes(notesConverter.convert(recipe.getNotes()));

            if (recipe.getIngredients() != null && recipe.getIngredients().size() > 0) {
                recipe.getIngredients()
                        .forEach(ingredient -> command.getIngredients().add(ingredientConverter.convert(ingredient)));
            }

            if (recipe.getCategories() != null && recipe.getCategories().size() > 0) {
                recipe.getCategories()
                        .forEach(category -> command.getCategories().add(categoryConveter.convert(category)));
            }

            return command;
        }

        return null;
    }
}
