package com.okan.recipe.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Author:   Okan Hollander
 * Date:     30/12/2019
 * Time:     13:06
 */
@Getter
@Setter
@Document
public class Notes {

    // == Fields ==
    @Id
    private String id;
    private Recipe recipe;
    private String recipeNotes;

}
