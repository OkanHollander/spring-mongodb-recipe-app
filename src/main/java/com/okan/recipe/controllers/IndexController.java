package com.okan.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     18:21
 */
@Controller
public class IndexController {

    @GetMapping({"", "/", "/index"})
    public String getIndexPage() {

        return "index";
    }
}
