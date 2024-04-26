package ru.gb.notes_hw5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.notes_hw5.model.Note;
import ru.gb.notes_hw5.repository.NoteRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class NoteService {

    NoteRepository noteRepository;

    public Note createNote(Note note){
        return noteRepository.save(note);
    }

    public List<Note> findAllNotes(){
        return noteRepository.findAll();
    }

//    public List<Note> findNotesByStatus(String status){
//        return findNotesByStatus(status);
//    }

//    public Note updateNoteStatusById(Long id, String status){
//        Optional<Note> optionalNote = noteRepository.findById(id);
//        if (optionalNote.isPresent()) {
//            Note note = optionalNote.get();
//            note.changeStatus(status);
//            note.setCreatedAt(new Date());
//            return noteRepository.save(note);
//        } else {
//            throw new IllegalArgumentException("Note with id: " + id + " not found");
//        }
//    }


}
