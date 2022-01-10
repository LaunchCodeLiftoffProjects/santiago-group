package com.recipeproject.recipeproject.controllers;

import com.recipeproject.recipeproject.models.*;
import com.recipeproject.recipeproject.models.data.IngredientRepository;
import com.recipeproject.recipeproject.models.data.JunctionRepository;
import com.recipeproject.recipeproject.models.data.RecipeRepository;
import com.recipeproject.recipeproject.models.data.RecipeStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddRecipe {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeStepRepository recipeStepRepository;
    @Autowired
    private JunctionRepository junctionRepository;

    //This is totally untested other than ensuring it doesn't break the whole program
    @PostMapping("add")
    public String processRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "index";
        }
        recipeRepository.save(newRecipe);

        List<Ingredient> tempList = newRecipe.getIngredientList();
        for (Ingredient ingredient: tempList) {
            Junction newRow = new Junction(newRecipe, ingredient, ingredient.getMeasurement(), ingredient.getAmount(), ingredient.getPrepNotes());
            junctionRepository.save(newRow);

            if(!ingredientRepository.findByName(ingredient.getName())){
                ingredientRepository.save(ingredient);
            }

        }
        List<RecipeStep> steps = newRecipe.getRecipeSteps();
        for(RecipeStep recipeStep: steps){
            recipeStepRepository.save(recipeStep);
        }
        return "index";
    }
}
