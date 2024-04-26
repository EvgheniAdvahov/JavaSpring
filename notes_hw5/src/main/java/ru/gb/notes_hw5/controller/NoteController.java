package ru.gb.notes_hw5.controller;

import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.web.bind.annotation.*;
import ru.gb.notes_hw5.model.Note;
import ru.gb.notes_hw5.service.NoteService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("notes")
@AllArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping()
    public List<Note> getAllNotes(){
        return noteService.findAllNotes();
    }

    @PostMapping("/add")
    public void addNote(@RequestBody Note note){
        note.setCreatedAt(new Date());
        noteService.createNote(note);
    }
}
