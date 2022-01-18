package com.recipeproject.recipeproject.models;

import javax.persistence.*;

@Entity

public class Junction {
    @Id
    @GeneratedValue
   private Integer junctionID;


    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name = "ingredientId")
    private Ingredient ingredient;
    @ManyToOne
    @JoinColumn(name = "measurementId")
    private Measurement measurement;

    private String amount;

    private String prepNotes;

    public Junction(Recipe recipe, Ingredient ingredient, Measurement measurement, String amount, String prepNotes) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.amount = amount;
        this.prepNotes = prepNotes;
    }
    public Junction() {
    }



    public int getJunctionID() {
        return junctionID;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public String getAmount() {
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

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPrepNotes(String prepNotes) {
        this.prepNotes = prepNotes;
    }
}
