package com.okan.recipe.controllers;

import com.okan.recipe.commands.RecipeCommand;
import com.okan.recipe.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Author:   Okan Hollander
 * Date:     03/01/2020
 * Time:     08:14
 */
public class IngredientControllerTest {

    @Mock
    RecipeService recipeService;

    MockMvc mockMvc;
    IngredientController ingredientController;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        ingredientController = new IngredientController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
    }


    @Test
    public void testListIngredients()throws Exception {

        // given
        RecipeCommand command = new RecipeCommand();
        when(recipeService.findCommandById(anyLong())).thenReturn(command);

        // when
        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/list"))
                .andExpect(model().attributeExists("recipe"));

        // then
        verify(recipeService, times(1)).findCommandById(anyLong());


    }
}
