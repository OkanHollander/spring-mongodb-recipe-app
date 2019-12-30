package com.okan.recipe.controllers;

import com.okan.recipe.domain.Category;
import com.okan.recipe.domain.UnitOfMeasure;
import com.okan.recipe.repositories.CategoryRepository;
import com.okan.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     18:21
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @GetMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is= " + categoryOptional.get().getId());
        System.out.println("UoM Id is= " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
