package com.recipeproject.recipeproject.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.recipeproject.recipeproject.models.Measurement;

@Repository
public interface MeasurementRepository extends CrudRepository {
}
