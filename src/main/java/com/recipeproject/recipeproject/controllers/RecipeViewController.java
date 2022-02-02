package com.recipeproject.recipeproject.controllers;

import com.recipeproject.recipeproject.models.Junction;
import com.recipeproject.recipeproject.models.Recipe;
import com.recipeproject.recipeproject.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("view")
@Controller
public class RecipeViewController {

    @Autowired
    RecipeRepository recipeRepository;

    @RequestMapping("")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("{recipeId}")
    public String displayViewRecipe(Model model, @PathVariable int recipeId) {

        Optional<Recipe> optRecipe = recipeRepository.findById(recipeId);
        if (optRecipe.isPresent()) {
            Recipe recipe = (Recipe) optRecipe.get();
            model.addAttribute("recipe", recipe);
            model.addAttribute("recipeIngredients", recipe.getIngredientJunctions());
            return "view";
        } else {
            return "redirect:/home";
        }

    }

}
