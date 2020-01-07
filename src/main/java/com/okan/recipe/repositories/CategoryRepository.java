package com.okan.recipe.repositories;

import com.okan.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Author:   Okan Hollander
 * Date:     30/12/2019
 * Time:     16:29
 */
public interface CategoryRepository extends CrudRepository<Category, String> {

    Optional<Category> findByDescription(String description);
}
