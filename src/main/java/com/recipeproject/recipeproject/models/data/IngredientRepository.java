package com.recipeproject.recipeproject.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.recipeproject.recipeproject.models.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository <Ingredient, Integer> {


    boolean findByName(String name);
}
