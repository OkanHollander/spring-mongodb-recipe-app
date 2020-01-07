package com.okan.recipe.converters;

import com.okan.recipe.commands.CategoryCommand;
import com.okan.recipe.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author:   Okan Hollander
 * Date:     02/01/2020
 * Time:     13:32
 */
public class CategoryCommandToCategoryTest {

    public static final String DESCRIPTION = "description";
    public static final String STRING_VALUE = "1";

    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject()throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {

        // given
        CategoryCommand command = new CategoryCommand();
        command.setId(STRING_VALUE);
        command.setDescription(DESCRIPTION);

        // when
        Category category = converter.convert(command);

        // then
        assertNotNull(category);
        assertEquals(STRING_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}
