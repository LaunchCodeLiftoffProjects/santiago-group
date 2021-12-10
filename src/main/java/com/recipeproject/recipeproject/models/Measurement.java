package com.recipeproject.recipeproject.models;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Measurement {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private double quantity;

    private String measurement;

    public int getId() {
        return id;
    }


    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
}
