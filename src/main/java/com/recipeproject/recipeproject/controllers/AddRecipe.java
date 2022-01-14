package com.recipeproject.recipeproject.controllers;

import com.recipeproject.recipeproject.models.*;
import com.recipeproject.recipeproject.models.data.*;
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
    List<Ingredient> ingredientList = new ArrayList<>();
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeStepRepository recipeStepRepository;
    @Autowired
    private JunctionRepository junctionRepository;
    @Autowired
    private MeasurementRepository measurementRepository;

    //This is totally untested other than ensuring it doesn't break the whole program
    @GetMapping("add")
    public String processRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "dbTest";
        }
        recipeRepository.save(newRecipe);


        for (Ingredient ingredient: ingredientList) {
            Junction newRow = new Junction(newRecipe, ingredient, ingredient.getMeasurement(), ingredient.getAmount(), ingredient.getPrepNotes());
            junctionRepository.save(newRow);
            Measurement newMeas = new Measurement(ingredient.getMeasurement().getMeasurement());
            measurementRepository.save(newMeas);
            if(!ingredientRepository.findByName(ingredient.getName())){
                ingredientRepository.save(ingredient);
            }

        }
        List<RecipeStep> steps = newRecipe.getRecipeSteps();
        for(RecipeStep recipeStep: steps){
            recipeStepRepository.save(recipeStep);
        }
        return "dbTest";
    }
    //Need to add a controller to do same for Recipe Steps and one for the first part of the form with Recipe name & description

    @PostMapping("addIngredient")
    private String makeIngredientList(Model model, @RequestParam String ingredientName, @RequestParam String ingredientMeasure, @RequestParam String ingredientQuan, @RequestParam String ingredientNote){
        Measurement tempMeas = new Measurement(ingredientMeasure);

        Ingredient tempIngredient = new Ingredient(ingredientName, tempMeas, ingredientNote, ingredientQuan);
        ingredientList.add(tempIngredient);
        return "dbTest";

    }



}
