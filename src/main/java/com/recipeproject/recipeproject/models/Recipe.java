package com.recipeproject.recipeproject.models;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Integer recipeId;

    @NotNull
    private String name;

    //@NotNull
    private String description;
    @Nullable
    private String cook_time;
    @Nullable
    private String total_time;
    @Nullable
    private String yield;


    @OneToMany
    @JoinColumn(name = "recipeId")
    private List <RecipeStep> recipeSteps = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "ingredientId")
    private List <Ingredient> ingredientList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "recipeId")
    private List<Junction> ingredientJunctions;

    public Recipe() {
    }

    public Recipe(String name, String description, String cook_time, String total_time, String yield) {
        this.name = name;
        this.description = description;
        this.cook_time = cook_time;
        this.total_time = total_time;
        this.yield = yield;
    }

    public Recipe(String name, String description, List<RecipeStep> recipeSteps, List<Ingredient> ingredientList) {
        this.name = name;
        this.description = description;
        this.recipeSteps = recipeSteps;
        this.ingredientList = ingredientList;
    }

    public Recipe(String name, String description, String cook_time, String total_time, String yield, List<RecipeStep> recipeSteps, List<Ingredient> ingredientList) {
        this.name = name;
        this.description = description;
        this.cook_time = cook_time;
        this.total_time = total_time;
        this.yield = yield;
        this.recipeSteps = recipeSteps;
        this.ingredientList = ingredientList;
    }

    public Integer getRecipeId() {
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

    public List<RecipeStep> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<RecipeStep> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    public List<Junction> getIngredientJunctions() {
        return ingredientJunctions;
    }

    public void setIngredientJunctions(List<Junction> ingredientJunctions) {
        this.ingredientJunctions = ingredientJunctions;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getCook_time() {
        return cook_time;
    }

    public void setCook_time(String cook_time) {
        this.cook_time = cook_time;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeId(), getName());
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
