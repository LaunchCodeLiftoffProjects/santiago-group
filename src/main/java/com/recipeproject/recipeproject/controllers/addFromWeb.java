package com.recipeproject.recipeproject.controllers;

import com.recipeproject.recipeproject.models.*;
import com.recipeproject.recipeproject.models.data.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Service
@Controller
@RequestMapping("addFromWeb")
public class addFromWeb {

    @GetMapping("")
    public String displayCreateEventForm(Model model) {
        model.addAttribute(new Recipe());
        return "addFromWeb";
    }

    @PostMapping("")
    public String processCreateEventForm(@ModelAttribute @Valid Recipe newRecipe,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "addFromWeb";
        }

        return "redirect:/home";
    }

}
