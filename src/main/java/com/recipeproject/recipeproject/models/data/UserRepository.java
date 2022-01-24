package com.recipeproject.recipeproject.models.data;

import com.recipeproject.recipeproject.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
