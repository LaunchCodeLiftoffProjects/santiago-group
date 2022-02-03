package com.recipeproject.recipeproject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class RecipeStep {

    @Id
    @GeneratedValue
    private int stepId;

    @NotNull
    private Integer stepNumber;

    @NotNull
    @Lob
    @Column(length = 10000)
    private String stepDescription;


    private Integer recipeId;


    public RecipeStep() {
    }
    public RecipeStep(Integer stepNumber, String stepDescription, Integer recipeId){

    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    public Integer getStepId() {
        return stepId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }
}

