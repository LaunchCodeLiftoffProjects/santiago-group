package com.recipeproject.recipeproject.models;

import javax.persistence.*;

@Entity
public class Junction {
    @Id
    @GeneratedValue
   private int junctionID;


    @OneToMany
    private int recipeId;
    @OneToMany
    private int ingredientId;
    @OneToMany
    private int measurementID;

    private String amount;

    private String prepNotes;

}
