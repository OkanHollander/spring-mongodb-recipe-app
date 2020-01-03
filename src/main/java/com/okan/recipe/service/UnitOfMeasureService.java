package com.okan.recipe.service;

import com.okan.recipe.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * Author:   Okan Hollander
 * Date:     03/01/2020
 * Time:     19:55
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
