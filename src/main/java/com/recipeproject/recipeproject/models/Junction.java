package com.recipeproject.recipeproject.models;

import javax.persistence.*;
import java.util.Optional;

@Entity

public class Junction {
    @Id
    @GeneratedValue
   private Integer junctionID;


    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name = "name")
    private Ingredient ingredient;
    private String measurement;

    private Double amount;

    private String prepNotes;

    public Junction(Recipe recipe, Ingredient ingredient, String measurement, Double amount, String prepNotes) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.amount = amount;
        this.prepNotes = prepNotes;
    }
    public Junction() {
    }



    public Integer getJunctionID() {
        return junctionID;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public String getMeasurement() {
        return measurement;
    }

    public Double getAmount() {
        return amount;
    }

    public String getPrepNotes() {
        return prepNotes;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPrepNotes(String prepNotes) {
        this.prepNotes = prepNotes;
    }
}
