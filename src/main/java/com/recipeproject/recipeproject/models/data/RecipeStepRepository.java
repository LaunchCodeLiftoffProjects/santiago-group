package com.recipeproject.recipeproject.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.recipeproject.recipeproject.models.RecipeStep;

@Repository
public interface RecipeStepRepository extends CrudRepository {
}
