package com.okan.recipe.converters;

import com.okan.recipe.commands.NotesCommand;
import com.okan.recipe.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author:   Okan Hollander
 * Date:     02/01/2020
 * Time:     15:01
 */
public class NotesCommandToNotesTest {

    public static final String DESCRIPTION = "description";
    public static final String STRING_VALUE = "1";

    NotesCommandToNotes converter;

    @Before
    public void setUp() throws Exception {

        converter = new NotesCommandToNotes();
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void convert() {

        // given
        NotesCommand command = new NotesCommand();
        command.setId(STRING_VALUE);
        command.setRecipeNotes(DESCRIPTION);

        // when
        Notes notes = converter.convert(command);

        // then
        assertNotNull(notes);
        assertEquals(STRING_VALUE, notes.getId());
        assertEquals(DESCRIPTION, notes.getRecipeNotes());


    }
}
