package com.okan.recipe.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Author:   Okan Hollander
 * Date:     30/12/2019
 * Time:     13:27
 */
@Getter
@Setter
@Document
public class Ingredient {

    // == Fields ==
    @Id
    private String id;
    private String description;
    private BigDecimal amount;

    @DBRef
    private UnitOfMeasure uom;

    // == constructors ==
    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }


    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
//        this.recipe = recipe;
    }


}
