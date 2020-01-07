package com.okan.recipe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Author:   Okan Hollander
 * Date:     30/12/2019
 * Time:     13:41
 */
@Getter
@Setter
@Entity
public class UnitOfMeasure {

    // == Fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String description;


}
