package com.recipeproject.recipeproject.controllers;

import com.recipeproject.recipeproject.models.dto.LoginFormDTO;
import com.recipeproject.recipeproject.models.dto.RegisterFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AthenticationController {

    @GetMapping("login")
    public String loginPage (Model model) {
        model.addAttribute(new LoginFormDTO());
        return "login";
    }

    @GetMapping("add")
    public String register (Model model) {
        model.addAttribute(new RegisterFormDTO());
        return "register";
    }

}
