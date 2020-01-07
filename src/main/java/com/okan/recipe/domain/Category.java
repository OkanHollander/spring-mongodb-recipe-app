package com.okan.recipe.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Set;

/**
 * Author:   Okan Hollander
 * Date:     30/12/2019
 * Time:     15:42
 */
@Getter
@Setter
@Document
public class Category {

    // == Fields ==
    @Id
    private String id;

    @DBRef
    private Set<Recipe> recipes;
    private String description;


}
