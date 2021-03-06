package com.okan.recipe.controllers;

import com.okan.recipe.commands.RecipeCommand;
import com.okan.recipe.exceptions.NotFoundException;
import com.okan.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Author:   Okan Hollander
 * Date:     02/01/2020
 * Time:     07:59
 */
@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/{id}/show")
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(id));
        return "recipe/show";
    }

    @RequestMapping("/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @RequestMapping("/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(id));
        return "recipe/recipeform";
    }

    @PostMapping("")
    public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });

            return "recipe/recipeform";
        }


        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping("/{id}/delete")
    public String deleteRecipe(@PathVariable String id) {
        log.debug("Deleting id - " + id);

        recipeService.deleteById(id);

        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {
        log.error("Handling not found exception.");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        // set view name
        modelAndView.setViewName("errors/404error");
        // set model name
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }

}
