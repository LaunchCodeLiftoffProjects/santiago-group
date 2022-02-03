package com.recipeproject.recipeproject.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddRecipeDTO {
    @NotNull
    @NotBlank
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
