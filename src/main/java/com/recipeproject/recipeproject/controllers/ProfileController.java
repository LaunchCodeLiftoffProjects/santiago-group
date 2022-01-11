package com.recipeproject.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/profile")
@Controller
<<<<<<< Updated upstream:src/main/java/com/recipeproject/recipeproject/controllers/ProfileController.java
public class ProfileController {
    @RequestMapping("Profile")
    public String index(Model model) {
=======
public class FormController {
    @RequestMapping("Form")
    public String form(Model model) {
>>>>>>> Stashed changes:src/main/java/com/recipeproject/recipeproject/controllers/FormController.java

        return "profile";
    }
}