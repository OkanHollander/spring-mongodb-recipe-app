package com.okan.recipe.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

/**
 * Author:   Okan Hollander
 * Date:     30/12/2019
 * Time:     13:06
 */
@Document
@Getter
@Setter
public class Recipe {

    // == Fields ==
    @Id
    private String id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Byte[] image;
    private Notes notes;
    private Set<Ingredient> ingredients = new HashSet<>();

    @DBRef
    private Set<Category> categories = new HashSet<>();


    public void setNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
        }
    }

    public Recipe addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
        return this;
    }


}
