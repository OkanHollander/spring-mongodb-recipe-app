package com.okan.recipe.converters;

import com.okan.recipe.commands.IngredientCommand;
import com.okan.recipe.commands.UnitOfMeasureCommand;
import com.okan.recipe.domain.Ingredient;
import com.okan.recipe.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Author:   Okan Hollander
 * Date:     02/01/2020
 * Time:     14:39
 */
public class IngredientCommandToIngredientTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long UOM_ID = new Long(2L);
    public static final Long ID_VALUE = new Long(1L);

    IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullParameter() {
        converter.convert(null);
    }

    @Test
    public void testEmptyObject() {
        converter.convert(new IngredientCommand());
    }

    @Test
    public void testWithNoUom() {

        // given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setDescription(DESCRIPTION);
        command.setAmount(AMOUNT);
        command.setUom(null);

        // when
        Ingredient ingredient = converter.convert(command);

        // then
        assertNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
    }

    @Test
    public void TestWithUom() {
        // given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setDescription(DESCRIPTION);
        command.setAmount(AMOUNT);

        UnitOfMeasureCommand uom = new UnitOfMeasureCommand();
        command.setUom(uom);

        // when
        Ingredient ingredient = converter.convert(command);

        // then
        assertNotNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
    }
}
