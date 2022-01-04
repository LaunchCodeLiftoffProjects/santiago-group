package com.regitcipeproject.recipeproject.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Notes for later:  Recipe upload screen should check ingredient name against ingredient
// DB, if not found ask user to check spelling

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private int ingredientId;

    @NotNull
    private String name;



    public Ingredient() {
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
}
