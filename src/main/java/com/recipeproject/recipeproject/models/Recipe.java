package com.recipeproject.recipeproject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue

    private int recipeId;

    @NotNull
    private String name;

    //@NotNull
    private String description;

    public Recipe() {
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

