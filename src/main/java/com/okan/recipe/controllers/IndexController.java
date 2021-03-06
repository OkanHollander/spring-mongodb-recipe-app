package com.okan.recipe.controllers;

import com.okan.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     18:21
 */
@Controller
@Slf4j
public class IndexController {

    private final RecipeService recipeService;

    @Autowired
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {


        log.debug("In getIndexPage()");

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
