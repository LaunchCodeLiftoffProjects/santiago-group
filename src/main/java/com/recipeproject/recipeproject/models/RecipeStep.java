package com.recipeproject.recipeproject.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class RecipeStep {

    @Id
    private int stepNumber;

    @NotNull
    private String stepDescription;

    //Set up recipeID as foreign key?



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
}
