package com.recipeproject.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("recipe-view")
@Controller
public class RecipeViewController {
    @RequestMapping("")
    public String index(Model model) {

        return "recipeView";
    }
}
