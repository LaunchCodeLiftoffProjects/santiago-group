package com.recipeproject.recipeproject.controllers;

import com.recipeproject.recipeproject.models.Junction;
import com.recipeproject.recipeproject.models.Recipe;
import com.recipeproject.recipeproject.models.User;
import com.recipeproject.recipeproject.models.data.RecipeRepository;
import com.recipeproject.recipeproject.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("view")
@Controller
public class RecipeViewController {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("{recipeId}")
    public String displayViewRecipe(Model model, @PathVariable int recipeId, HttpServletRequest request) {

        Optional<Recipe> optRecipe = recipeRepository.findById(recipeId);
        if (optRecipe.isPresent()) {
            Recipe recipe = (Recipe) optRecipe.get();
            model.addAttribute("recipe", recipe);
            model.addAttribute("recipeIngredients", recipe.getIngredientJunctions());

            HttpSession session = (request.getSession());
            Object userId = session.getAttribute("user");
            User user = userRepository.findById((Integer)userId).get();
            Recipe recipeFound = recipeRepository.findById(recipeId).get();
            List<Recipe> favorites = user.getRecipeFavorites();
            if (favorites.contains(recipeFound)) {
                model.addAttribute("disabled", true);
            }
                return "view";
        } else {
            return "redirect:/home";
        }

    }

    @PostMapping("add-favorite/{recipeId}")
    public String addFavorite(HttpServletRequest request, @PathVariable Integer recipeId) {
        HttpSession session = (request.getSession());
        Object userId = session.getAttribute("user");
        User user = userRepository.findById((Integer)userId).get();
        Recipe recipe = recipeRepository.findById(recipeId).get();
        List<Recipe> favorites = user.getRecipeFavorites();
        favorites.add(recipe);
        user.setRecipeFavorites(favorites);
        userRepository.save(user);
        return "redirect:/view/" + recipeId;
    }

}
