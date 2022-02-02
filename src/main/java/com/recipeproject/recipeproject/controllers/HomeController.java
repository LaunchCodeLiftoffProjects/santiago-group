package com.recipeproject.recipeproject.controllers;


import com.recipeproject.recipeproject.models.Recipe;
import com.recipeproject.recipeproject.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("home")
    public String index(Model model) {
        List<Recipe> allRecipes = new ArrayList<>();
        List<Recipe> featuredRecipes = new ArrayList<>();

        recipeRepository.findAll().forEach(allRecipes::add);
        //Shuffle the list of recipes to randomize it so that we can pull out featured recipes
        Collections.shuffle(allRecipes);

        //Pick the first 3 in the shuffled list to be featured (but only add if they exist)
        if (allRecipes.size() > 0) { featuredRecipes.add(allRecipes.get(0)); }
        if (allRecipes.size() > 1) { featuredRecipes.add(allRecipes.get(1)); }
        model.addAttribute("recipes", featuredRecipes);
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
