package com.recipeproject.recipeproject.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    //@NotNull
    private String description;

    public int getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return getId() == recipe.getId() && Objects.equals(getName(), recipe.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    /**
     * Search all Recipe fields for the given term.
     *
     * @param keyword The search term to look for.
     * @param allRecipes The list of recipes to search.
     * @return List of all recipes with at least one field containing the value.
     */
    public static ArrayList<Recipe> searchByKeyword(String keyword, Iterable<Recipe> allRecipes) {
        String lower_keyword = keyword.toLowerCase();

        ArrayList<Recipe> results = new ArrayList<>();

        for (Recipe recipe : allRecipes) {

            if (recipe.getName().toLowerCase().contains(lower_keyword)) {
                results.add(recipe);
            } else if (recipe.getDescription().toLowerCase().contains(lower_keyword)) {
                results.add(recipe);
            }
            //Todo: once this model gets connected to the ingredient and recipeStep models
            // (and any other relevant fields), add those to the if/else if statement, to
            // check if they contain the keyword

        }

        return results;
    }
}
