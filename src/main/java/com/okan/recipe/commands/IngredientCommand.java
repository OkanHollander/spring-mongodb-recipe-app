package com.okan.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Author:   Okan Hollander
 * Date:     02/01/2020
 * Time:     11:47
 */
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {

    private Long id;
    private Long RecipeId;
    private BigDecimal amount;
    private String description;
    private UnitOfMeasureCommand uom;
}
