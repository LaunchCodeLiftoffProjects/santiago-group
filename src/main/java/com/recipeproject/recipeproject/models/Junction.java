package com.recipeproject.recipeproject.models;

import javax.persistence.*;

@Entity

public class Junction {
    @Id
    @GeneratedValue
   private int junctionID;


    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name = "ingredientId")
    private Ingredient ingredient;
    @ManyToOne
    @JoinColumn(name = "measurementId")
    private Measurement measurement;

    private String amount;

    private String prepNotes;

    public Junction() {
    }

}
