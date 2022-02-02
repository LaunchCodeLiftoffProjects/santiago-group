package com.recipeproject.recipeproject.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
//This class exists to store the JSON data temporarily
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataParser {
    private String name;
    private String prep_time;
    private String cook_time;
    private String total_time;
    private String yield;
    private String description;

    private List<String> ingredients;
    //this is set up weird because the json data is nested stupidly
    private List<Instructions> instructions;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrep_time() {
        return prep_time;
    }

    public void setPrep_time(String prep_time) {
        this.prep_time = prep_time;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<Instructions> getInstructions() {        return instructions;    }

    public void setInstructions(List<Instructions> instructions) {this.instructions = instructions;}

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;



    }
}
