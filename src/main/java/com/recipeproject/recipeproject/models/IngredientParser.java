package com.recipeproject.recipeproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class IngredientParser {


    private IngApi ingredientParsed;



    public IngApi getIngredientParsed() {
        return ingredientParsed;
    }

    public void setIngredientParsed(IngApi ingredientParsed) {
        this.ingredientParsed = ingredientParsed;
    }
}
