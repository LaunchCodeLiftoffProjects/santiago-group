package com.recipeproject.recipeproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class IngredientParser {

    private double confidence;
    private List<IngApi> ingredientParsed;

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public List<IngApi> getIngredientParsed() {
        return ingredientParsed;
    }

    public void setIngredientParsed(List<IngApi> ingredientParsed) {
        this.ingredientParsed = ingredientParsed;
    }
}
