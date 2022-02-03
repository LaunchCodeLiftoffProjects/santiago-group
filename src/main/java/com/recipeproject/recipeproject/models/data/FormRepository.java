package com.recipeproject.recipeproject.models.data;

import com.recipeproject.recipeproject.models.Ingredient;
import com.recipeproject.recipeproject.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.applet.Applet;

@Repository
public interface FormRepository extends CrudRepository <Recipe, Ingredient> {

}
