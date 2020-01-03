package com.okan.recipe.service;

import com.okan.recipe.commands.UnitOfMeasureCommand;
import com.okan.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.okan.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Author:   Okan Hollander
 * Date:     03/01/2020
 * Time:     19:55
 */
@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand measureCommand;

    @Autowired
    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand measureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.measureCommand = measureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll()
        .spliterator(), false)
                .map(measureCommand::convert)
                .collect(Collectors.toSet());
    }
}
