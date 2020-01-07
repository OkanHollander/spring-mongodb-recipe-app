package com.okan.recipe.repositories;

import com.okan.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Author:   Okan Hollander
 * Date:     30/12/2019
 * Time:     16:18
 */
public interface RecipeRepository extends CrudRepository<Recipe, String> {



}
