package com.okan.recipe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author:   Okan Hollander
 * Date:     30/12/2019
 * Time:     13:06
 */
@Entity
@Data
@EqualsAndHashCode(exclude = {"ingredients", "notes", "categories"})
public class Recipe {

    // == Fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();


    // == Getters and Setters ==
    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }


    // == methods ==
    public void addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);

    }
//    public Recipe addIngredient(Ingredient ingredient) {
//        ingredient.setRecipe(this);
//        this.ingredients.add(ingredient);
//
//        return this;
//    }


}
