package com.okan.recipe.repositories;

import com.okan.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Author:   Okan Hollander
 * Date:     30/12/2019
 * Time:     16:29
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {


}
