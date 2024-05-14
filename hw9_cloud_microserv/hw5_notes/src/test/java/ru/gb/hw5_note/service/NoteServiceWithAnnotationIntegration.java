package ru.gb.hw5_note.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.hw5_note.model.Note;
import ru.gb.hw5_note.model.Status;
import ru.gb.hw5_note.repository.NoteRepository;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
public class NoteServiceWithAnnotationIntegration {

    @Autowired
    private NoteService noteService;

    @MockBean
    private NoteRepository noteRepository;

    @Test
    public void updateByID() {
        //Блок предусловия
        Note note = new Note();
        note.setId(1L);
        note.setDescription("сходить в магазин");
        note.setCreatedAt(new Date());
        note.setStatus(Status.NOT_STARTED);

        when(noteRepository.findById(note.getId())).thenReturn(Optional.of(note));

        //Блок вызова
        noteService.updateByID(1L, Status.IN_PROGRESS);

        //Блок проверки
        assertEquals(Status.IN_PROGRESS, note.getStatus());
    }


}
