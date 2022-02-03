package com.recipeproject.recipeproject.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.recipeproject.recipeproject.models.IngredientParser;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class IngredientResponseDTO {
    private List<IngredientParser> results;

    public List<IngredientParser> getResults() {
        return results;
    }

    public void setResults(List<IngredientParser> results) {
        this.results = results;
    }
}
