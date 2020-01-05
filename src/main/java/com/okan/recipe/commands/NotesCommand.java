package com.okan.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Author:   Okan Hollander
 * Date:     02/01/2020
 * Time:     11:47
 */
@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String recipeNotes;
}
