package com.recipeproject.recipeproject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

import com.recipeproject.recipeproject.models.Junction;

//Notes for later:  Recipe upload screen should check ingredient name against ingredient
// DB, if not found ask user to check spelling

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private Integer ingredientId;

    @NotNull
    private String name;

    @Transient
    private String measurement;

    @Transient
    private String prepNotes;

    @Transient
    private Double amount;


    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient(String name, String measurement, String prepNotes, Double amount) {
        this.name = name;
        this.measurement = measurement;
        this.prepNotes = prepNotes;
        this.amount = amount;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getPrepNotes() {
        return prepNotes;
    }

    public void setPrepNotes(String prepNotes) {
        this.prepNotes = prepNotes;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
