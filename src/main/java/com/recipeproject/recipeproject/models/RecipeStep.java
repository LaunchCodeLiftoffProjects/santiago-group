package com.recipeproject.recipeproject.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class RecipeStep {

    @Id
    @GeneratedValue
    private int stepId;

    @NotNull
    private Integer stepNumber;

    @NotNull
    private String stepDescription;

    private Integer recipeId;


    public RecipeStep() {
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

    public int getStepId() {
        return stepId;
    }

    }

