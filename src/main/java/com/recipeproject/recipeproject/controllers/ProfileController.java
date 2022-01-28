package com.recipeproject.recipeproject.controllers;

import com.recipeproject.recipeproject.models.User;
import com.recipeproject.recipeproject.models.data.RecipeRepository;
import com.recipeproject.recipeproject.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequestMapping("/profile")
@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute("user", user.getId());
        session.setAttribute("username", user.getUsername());
    }

    @GetMapping
    public String index(Model model, HttpServletRequest request) {
        HttpSession session = (request.getSession());
        Object username = session.getAttribute("username");
        model.addAttribute("myUsername", username);

        return "profile";
    }

    //profile/change-username
    @PostMapping("change-username")
    public String changeUsername(Model model, HttpServletRequest request, @RequestParam String usernameInput) {

        //user value given
//        User existingUser = userRepository.findByUsername("Hello");
//
//        if (existingUser != null) {
////            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
//            return "profile";
//        }

        HttpSession session = (request.getSession());
        Object userId = session.getAttribute("user");
        User user = userRepository.findById((Integer)userId).get();
        user.setUsername(usernameInput);
        userRepository.save(user);

        setUserInSession(session, user);

        return "redirect:/profile";
    }

    //profile
    @PostMapping("change-password")
    public String changePassword(Model model, HttpServletRequest request, @RequestParam String oldPasswordInput,
                                 @RequestParam String newPasswordInput, @RequestParam String newPasswordVerify) {

        HttpSession session = (request.getSession());
        Object userId = session.getAttribute("user");
        User user = userRepository.findById((Integer)userId).get();
//        if (oldPasswordInput != user.getPwHash()) {
//
//        }
        user.setPwHash(newPasswordInput);
        userRepository.save(user);
        setUserInSession(session, user);

        return "redirect:/profile";
    }
}
