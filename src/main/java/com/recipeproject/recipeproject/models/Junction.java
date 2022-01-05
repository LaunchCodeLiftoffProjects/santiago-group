package com.recipeproject.recipeproject.models;

import javax.persistence.*;

@Entity
@Table(name = "junction")
public class Junction {
    @Id
    @GeneratedValue
   private int junctionID;



    private int recipeId;
    @ManyToOne
    private int ingredientId;
    @ManyToOne
    private int measurementID;

    private String amount;

    private String prepNotes;

}
