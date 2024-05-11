package ru.gb.hw5_note.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.hw5_note.model.Note;
import ru.gb.hw5_note.model.Status;
import ru.gb.hw5_note.repository.NoteRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> findNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public void addNote(Note note) {
        noteRepository.save(note);
    }

    public List<Note> findNotesByStatus(Status status) {
        return noteRepository.findNotesByStatus(status);
    }

    public Note updateByID(Long id, Status status) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.changeStatus(status);
            note.setCreatedAt(new Date());
            return noteRepository.save(note);
        } else {
            throw new IllegalArgumentException("Note with id: " + id + " not found");
        }
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
