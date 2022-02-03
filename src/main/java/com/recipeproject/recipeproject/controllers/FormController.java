package com.recipeproject.recipeproject.controllers;
        import com.recipeproject.recipeproject.models.Recipe;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    @Autowired
    private FormController FormController;
    private Object Recipe;

    @RequestMapping("form")
    public String recipeForm() {
        return "<html>" +
                "<body>" +
                "<form>" +
                "<input>";
    }

    @GetMapping("/form")
    public String recipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "form";
    }

    @PostMapping("/form")
    public String recipeSubmit(Model model, @ModelAttribute String Recipe) {
        model.addAttribute("recipe", Recipe);
        return "form";
    }

}