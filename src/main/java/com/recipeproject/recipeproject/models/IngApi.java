package com.recipeproject.recipeproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IngApi {
    private String  preparationNotes;
    private  String product;

    private Double quantity;
    private String unit;

    public String getPreparationNotes() {
        return preparationNotes;
    }

    public void setPreparationNotes(String preparationNotes) {
        this.preparationNotes = preparationNotes;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }


    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
