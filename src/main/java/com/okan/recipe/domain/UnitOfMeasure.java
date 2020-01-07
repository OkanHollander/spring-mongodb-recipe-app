package com.okan.recipe.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Author:   Okan Hollander
 * Date:     30/12/2019
 * Time:     13:41
 */
@Getter
@Setter
@Document
public class UnitOfMeasure {

    // == Fields ==
    @Id
    private String id;
    private String description;


}
