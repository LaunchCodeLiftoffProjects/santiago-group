package com.recipeproject.recipeproject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

import com.recipeproject.recipeproject.models.Junction;

//Notes for later:  Recipe upload screen should check ingredient name against ingredient
// DB, if not found ask user to check spelling

@Entity
public class Ingredient {

    @Id
    @NotNull
    private String name;




    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
