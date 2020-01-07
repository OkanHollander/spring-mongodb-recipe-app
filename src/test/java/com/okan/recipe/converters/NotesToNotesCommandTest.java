package com.okan.recipe.converters;

import com.okan.recipe.commands.NotesCommand;
import com.okan.recipe.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author:   Okan Hollander
 * Date:     02/01/2020
 * Time:     14:48
 */
public class NotesToNotesCommandTest {

    public static final String DESCRIPTION = "description";
    public static final String STRING_VALUE = "1";

    NotesToNotesCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesToNotesCommand();
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    public void convert() {

        // given
        Notes notes = new Notes();
        notes.setId(STRING_VALUE);
        notes.setRecipeNotes(DESCRIPTION);

        // when
        NotesCommand command = converter.convert(notes);

        // then
        assertNotNull(command);
        assertEquals(STRING_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getRecipeNotes());
    }
}
