package com.recipeproject.recipeproject.controllers;


import com.recipeproject.recipeproject.models.Recipe;
import com.recipeproject.recipeproject.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("home")
    public String index(Model model) {

        return "index";
    }

    @GetMapping("search")
    public String displaySearchResults(Model model, @RequestParam String searchTerm){
        List<Recipe> recipesReturned = new ArrayList<>();
        if (searchTerm.isBlank()) {
            recipeRepository.findAll().forEach(recipesReturned::add);
        } else {
            recipesReturned = Recipe.searchByKeyword(searchTerm, recipeRepository.findAll());
        }

        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("recipes", recipesReturned);
        model.addAttribute("numberOfRecipesReturned", recipesReturned.size());

        return "search";
    }
}
