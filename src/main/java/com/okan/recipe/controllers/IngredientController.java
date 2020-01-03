package com.okan.recipe.controllers;

import com.okan.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author:   Okan Hollander
 * Date:     03/01/2020
 * Time:     08:13
 */
@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;

    @Autowired
    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("/recipe/{id}/ingredients")
    public String showIngredients(@PathVariable Long id, Model model) {

        log.debug("Show ingredients for Id - " +  id);

        model.addAttribute("recipe", recipeService.findCommandById(id));

        return "recipe/ingredient/list";
    }


}
