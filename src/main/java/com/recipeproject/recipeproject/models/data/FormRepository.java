package com.recipeproject.recipeproject.models.data;

import com.recipeproject.recipeproject.models.Ingredient;
import com.recipeproject.recipeproject.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import java.applet.Applet;

public interface FormRepository extends CrudRepository <Recipe, Ingredient> {

}
