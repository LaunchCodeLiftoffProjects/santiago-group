package com.recipeproject.recipeproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Entity
public class RecipeIngredients implements Serializable {

    @Id
    @JoinColumn(name = "recipeId")
    private Integer recipeId;

    @Id
    @JoinColumn(name = "ingredientId")
    private Integer ingredientId;

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }
}
