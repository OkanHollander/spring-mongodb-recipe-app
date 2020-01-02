package com.okan.recipe.converters;

import com.okan.recipe.commands.NotesCommand;
import com.okan.recipe.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Author:   Okan Hollander
 * Date:     02/01/2020
 * Time:     14:46
 */
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes notes) {
        if (notes != null) {
            final NotesCommand command = new NotesCommand();
            command.setId(notes.getId());
            command.setRecipeNotes(notes.getRecipeNotes());

            return command;
        }

        return null;
    }
}
