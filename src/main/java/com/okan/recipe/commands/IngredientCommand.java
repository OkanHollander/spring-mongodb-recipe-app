package com.okan.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    private String id;
    private String RecipeId;
    private BigDecimal amount;

    @NotBlank
    @Size(min = 3, max = 255)
    private String description;
    private UnitOfMeasureCommand uom;
}
