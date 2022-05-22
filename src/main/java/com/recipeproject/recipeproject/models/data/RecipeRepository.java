package com.recipeproject.recipeproject.models.data;

import com.recipeproject.recipeproject.models.DataParser;
import com.recipeproject.recipeproject.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}
