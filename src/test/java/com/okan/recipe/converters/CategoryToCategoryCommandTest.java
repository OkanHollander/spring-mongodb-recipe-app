package com.okan.recipe.converters;

import com.okan.recipe.commands.CategoryCommand;
import com.okan.recipe.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Author:   Okan Hollander
 * Date:     02/01/2020
 * Time:     12:52
 */
public class CategoryToCategoryCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullParameter() throws Exception {
        converter.convert(new Category());
    }

    @Test
    public void testEmptyObject()throws Exception {
        converter.convert(new Category());
    }

    @Test
    public void convert() {

        // given
        Category category = new Category();
        category.setId(LONG_VALUE);
        category.setDescription(DESCRIPTION);

        // when
        CategoryCommand command = converter.convert(category);

        //then
        assertNotNull(command);
        assertEquals(LONG_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}
