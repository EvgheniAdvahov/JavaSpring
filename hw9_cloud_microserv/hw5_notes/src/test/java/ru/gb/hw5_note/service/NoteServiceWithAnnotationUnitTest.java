package ru.gb.hw5_note.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.hw5_note.model.Note;
import ru.gb.hw5_note.model.Status;
import ru.gb.hw5_note.repository.NoteRepository;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class NoteServiceWithAnnotationUnitTest {

    @InjectMocks
    private NoteService noteService;

    @Mock
    private NoteRepository noteRepository;

    @Test
    public void updateByID() {
        //Блок предусловия
        Note note = new Note();
        note.setId(1L);
        note.setDescription("сходить в магазин");
        note.setCreatedAt(new Date());
        note.setStatus(Status.NOT_STARTED);

        given(noteRepository.findById(note.getId())).willReturn(Optional.of(note));

        //Блок вызова
        noteService.updateByID(1L, Status.IN_PROGRESS);

        //Блок проверки
        assertEquals(Status.IN_PROGRESS, note.getStatus());
    }
}
